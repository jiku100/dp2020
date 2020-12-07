package com.holub.database;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class HTMLExporterTest {
    class WriterMock extends FileWriter{
        private int callCount = 0;
        private ArrayList<String> outputs = new ArrayList<String>();

        public WriterMock(String fileName) throws IOException {
            super(fileName);
        }

        public void write(String buffer){
            outputs.add(buffer);
            callCount++;
        }
        public int getCallCount(){return this.callCount;}
        public ArrayList<String> getOutputs(){return this.outputs;}
    }
    @Test
    void storeMetadata() throws IOException {
        WriterMock out = new WriterMock("test.html");
        HTMLExporter exporter = new HTMLExporter(out);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.storeMetadata(testTableName, columnNames.size(), 0, columnNames.iterator());

        ArrayList<String> testString = new ArrayList<>();
        testString.add("\t<head>\n");
        testString.add("\t\t<title>");
        testString.add("student");
        testString.add("</title>\n");
        testString.add("\t</head>\n");
        testString.add("\t<body>\n");
        testString.add("\t\t<table>\n");
        testString.add("\t\t\t<thead>\n");
        testString.add("\t\t\t\t<tr>\n");
        testString.add("\t\t\t\t\t<th>");
        testString.add("name</th>");
        testString.add("<th>");
        testString.add("score</th>");
        testString.add("\n\t\t\t\t</tr>\n");
        testString.add("\t\t\t</thead>\n");
        testString.add("\t\t\t<tbody>\n");

        assertEquals(out.getCallCount(), 16);
        ArrayList<String> outString = out.getOutputs();
        for(int i = 0; i<testString.size(); i++){
            assertEquals(outString.get(i), testString.get(i));
        }
    }

    @Test
    void storeRow() {
        String a = "asd";
        String b = "asd";
        assertTrue(a.equals(b));
    }

    @Test
    void startTable() {
    }

    @Test
    void endTable() {
    }
}