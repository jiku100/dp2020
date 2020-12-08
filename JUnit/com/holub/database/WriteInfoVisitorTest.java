package com.holub.database;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WriteInfoVisitorTest {
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

    @Test
    void CSVvisit() throws IOException {
        WriterMock writer = new WriterMock();
        CSVExporter csv = new CSVExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        csv.storeMetadata(testTableName, columnNames.size(), 3, columnNames.iterator());

        StringBuilder testString = new StringBuilder();
        testString.append("File Type: csv\n");
        testString.append("Data File name: student.csv\n");
        testString.append("Table Name: student\n");
        testString.append("Number of Column: 2\n");
        testString.append("Kinds of Column: name score \n");
        testString.append("Number of Data: 3\n");
        csv.accept(new WriteInfoVisitor());
        File file = new File("c:/dp2020/student_Info_csv.txt");
        assertTrue(file.exists());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder expectString = new StringBuilder();
        for(int i = 0; i<6;i++){
            expectString.append(reader.readLine() + "\n");
        }
        assertEquals(testString.toString(), expectString.toString());
    }

    @Test
    void HTMLvisit() throws IOException {
        WriterMock writer = new WriterMock();
        HTMLExporter html = new HTMLExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        html.storeMetadata(testTableName, columnNames.size(), 3, columnNames.iterator());

        StringBuilder testString = new StringBuilder();
        testString.append("File Type: html\n");
        testString.append("Data File name: student.html\n");
        testString.append("Table Name: student\n");
        testString.append("Number of Column: 2\n");
        testString.append("Kinds of Column: name score \n");
        testString.append("Number of Data: 3\n");
        html.accept(new WriteInfoVisitor());
        File file = new File("c:/dp2020/student_Info_html.txt");
        assertTrue(file.exists());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder expectString = new StringBuilder();
        for(int i = 0; i<6;i++){
            expectString.append(reader.readLine() + "\n");
        }
        assertEquals(testString.toString(), expectString.toString());
    }

    @Test
    void XMLvisit() throws IOException {
        WriterMock writer = new WriterMock();
        XMLExporter xml = new XMLExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        xml.storeMetadata(testTableName, columnNames.size(), 3, columnNames.iterator());

        StringBuilder testString = new StringBuilder();
        testString.append("File Type: xml\n");
        testString.append("Data File name: student.xml\n");
        testString.append("Table Name: student\n");
        testString.append("Number of Column: 2\n");
        testString.append("Kinds of Column: name score \n");
        testString.append("Number of Data: 3\n");
        xml.accept(new WriteInfoVisitor());
        File file = new File("c:/dp2020/student_Info_xml.txt");
        assertTrue(file.exists());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder expectString = new StringBuilder();
        for(int i = 0; i<6;i++){
            expectString.append(reader.readLine() + "\n");
        }
        assertEquals(testString.toString(), expectString.toString());
    }
}