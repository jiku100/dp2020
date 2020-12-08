package com.holub.database;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class XMLExporterTest {
    class WriterMock extends Writer {
        private int callCount = 0;
        private StringBuilder outputs = new StringBuilder();

        public WriterMock() throws IOException {}

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {}

        public void write(String buffer){
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
    void storeMetadata() throws IOException {
        WriterMock out = new WriterMock();
        XMLExporter exporter = new XMLExporter(out);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.storeMetadata(testTableName, columnNames.size(), 0, columnNames.iterator());
        StringBuilder testString = new StringBuilder();
        testString.append("<student>\n");
        assertEquals(out.getCallCount(), 1);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void storeRow() throws IOException {
        WriterMock out = new WriterMock();
        XMLExporter exporter = new XMLExporter(out);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.storeMetadata(testTableName, columnNames.size(), 0, columnNames.iterator());

        ArrayList<String> info = new ArrayList<>();
        info.add("Shin");
        info.add("4.5");
        exporter.storeRow(info.iterator());
        info.clear();

        info.add("Seok");
        info.add("3.8");
        exporter.storeRow(info.iterator());

        info.clear();
        info.add("Gyeong");
        info.add("4.2");
        exporter.storeRow(info.iterator());

        StringBuilder testString = new StringBuilder();
        testString.append("<student>\n");
        testString.append("\t<student>\n");
        testString.append("\t\t<name>Shin</name>\n");
        testString.append("\t\t<score>4.5</score>\n");
        testString.append("\t</student>\n");
        testString.append("\t<student>\n");
        testString.append("\t\t<name>Seok</name>\n");
        testString.append("\t\t<score>3.8</score>\n");
        testString.append("\t</student>\n");
        testString.append("\t<student>\n");
        testString.append("\t\t<name>Gyeong</name>\n");
        testString.append("\t\t<score>4.2</score>\n");
        testString.append("\t</student>\n");
        assertEquals(out.getCallCount(), 25);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void startTable() throws IOException {
        WriterMock out = new WriterMock();
        XMLExporter exporter = new XMLExporter(out);
        exporter.startTable();

        StringBuilder testString = new StringBuilder();
        testString.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");

        assertEquals(out.getCallCount(), 1);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void endTable() throws IOException {
        WriterMock out = new WriterMock();
        XMLExporter exporter = new XMLExporter(out);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.storeMetadata(testTableName, columnNames.size(), 0, columnNames.iterator());
        exporter.endTable();
        
        StringBuilder testString = new StringBuilder();
        testString.append("<student>\n");
        testString.append("</student>\n");

        assertEquals(out.getCallCount(), 2);
        assertEquals(out.getOutputs(), testString.toString());
    }
}