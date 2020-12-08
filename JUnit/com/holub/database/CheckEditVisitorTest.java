package com.holub.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CheckEditVisitorTest {
    class WriterMock extends Writer {
        private int callCount = 0;
        private StringBuilder outputs = new StringBuilder();

        public WriterMock() throws IOException {}

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {}

        public void write(String buffer){
            if(buffer.startsWith("Last"))
                return;
            outputs.append(buffer);
            callCount++;
        }

        @Override
        public void flush() throws IOException {}

        @Override
        public void close() throws IOException {}

        public int getCallCount(){return this.callCount;}
        public String getOutputs(){return this.outputs.toString();}
    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    void CSVvisit() throws IOException {
        WriterMock writer = new WriterMock();
        CSVExporter csv = new CSVExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        columnNames.add("major");
        csv.storeMetadata(testTableName, columnNames.size(), 5, columnNames.iterator());
        csv.accept(new CheckEditVisitor());

        StringBuilder testString = new StringBuilder();
        testString.append("student_Info_csv.txt: Edited Columns Number 2 -> 3\n");
        testString.append("student_Info_csv.txt: Add New Column Names -> major\n");
        testString.append("student_Info_csv.txt: Edited Data Number 3 -> 5\n");
        assertEquals(testString.toString(), outContent.toString());
    }

    @Test
    void HTMLvisit() throws IOException {
        WriterMock writer = new WriterMock();
        HTMLExporter html = new HTMLExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        columnNames.add("major");
        html.storeMetadata(testTableName, columnNames.size(), 5, columnNames.iterator());
        html.accept(new CheckEditVisitor());

        StringBuilder testString = new StringBuilder();
        testString.append("student_Info_html.txt: Edited Columns Number 2 -> 3\n");
        testString.append("student_Info_html.txt: Add New Column Names -> major\n");
        testString.append("student_Info_html.txt: Edited Data Number 3 -> 5\n");
        assertEquals(testString.toString(), outContent.toString());
    }

    @Test
    void XMLvisit() throws IOException {
        WriterMock writer = new WriterMock();
        XMLExporter html = new XMLExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        columnNames.add("major");
        html.storeMetadata(testTableName, columnNames.size(), 5, columnNames.iterator());
        html.accept(new CheckEditVisitor());

        StringBuilder testString = new StringBuilder();
        testString.append("student_Info_xml.txt: Edited Columns Number 2 -> 3\n");
        testString.append("student_Info_xml.txt: Add New Column Names -> major\n");
        testString.append("student_Info_xml.txt: Edited Data Number 3 -> 5\n");
        assertEquals(testString.toString(), outContent.toString());
    }
}