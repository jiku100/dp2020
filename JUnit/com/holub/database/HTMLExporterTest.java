package com.holub.database;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class HTMLExporterTest {
    class WriterMock extends Writer{
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
        HTMLExporter exporter = new HTMLExporter(out);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.storeMetadata(testTableName, columnNames.size(), 0, columnNames.iterator());

        StringBuilder testString = new StringBuilder();
        testString.append("\t<body>\n");
        testString.append("\t\t<table>\n");
        testString.append("\t\t\t<caption>student</caption>\n");
        testString.append("\t\t\t<thead>\n");
        testString.append("\t\t\t\t<tr>\n");
        testString.append("\t\t\t\t\t<th>");
        testString.append("name</th>");
        testString.append("<th>");
        testString.append("score</th>");
        testString.append("\n\t\t\t\t</tr>\n");
        testString.append("\t\t\t</thead>\n");
        testString.append("\t\t\t<tbody>\n");

        assertEquals(out.getCallCount(), 14);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void storeRow() throws IOException {
        WriterMock out = new WriterMock();
        HTMLExporter exporter = new HTMLExporter(out);
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
        testString.append("\t\t\t\t<tr><td>Shin</td><td>4.5</td></tr>\n");
        testString.append("\t\t\t\t<tr><td>Seok</td><td>3.8</td></tr>\n");
        testString.append("\t\t\t\t<tr><td>Gyeong</td><td>4.2</td></tr>\n");

        assertEquals(out.getCallCount(), 24);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void startTable() throws IOException {
        WriterMock out = new WriterMock();
        HTMLExporter exporter = new HTMLExporter(out);
        StringBuilder testString = new StringBuilder();
        testString.append("<!DOCTYPE html>\n");
        testString.append("<html>\n");
        testString.append("\t<head></head>\n");
        exporter.startTable();
        assertEquals(out.getCallCount(), 3);
        assertEquals(out.getOutputs(), testString.toString());
    }

    @Test
    void endTable()  throws IOException {
        WriterMock out = new WriterMock();
        HTMLExporter exporter = new HTMLExporter(out);
        StringBuilder testString = new StringBuilder();
        testString.append("\t\t\t</tbody>\n");
        testString.append("\t\t</table>\n");
        testString.append("\t</body>\n");
        testString.append("</html>\n");
        exporter.endTable();
        assertEquals(out.getCallCount(), 4);
        assertEquals(out.getOutputs(), testString.toString());
    }
}