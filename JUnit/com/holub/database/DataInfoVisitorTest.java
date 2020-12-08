package com.holub.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DataInfoVisitorTest {
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
        CSVImporter csv = new CSVImporter(new FileReader("c:/dp2020/testFile/student.csv"));
        csv.startTable();
        csv.accept(new DataInfoVisitor());
        StringBuilder testString = new StringBuilder();
        testString.append("File Type: csv\n");
        testString.append("Data File name: student.csv\n");
        testString.append("Table Name: student\n");
        testString.append("Number of Column: 2\n");
        testString.append("Kinds of Column: name score \n");
        testString.append("Number of Data: 3\n");
        assertEquals(testString.toString(), outContent.toString().substring(0, outContent.size() - 37));
    }

    @Test
    void XMLvisit() throws IOException {
        XMLImporter xml = new XMLImporter(new FileReader("c:/dp2020/testFile/student.xml"));
        xml.startTable();
        xml.accept(new DataInfoVisitor());
        StringBuilder testString = new StringBuilder();
        testString.append("File Type: xml\n");
        testString.append("Data File name: student.xml\n");
        testString.append("Table Name: student\n");
        testString.append("Number of Column: 2\n");
        testString.append("Kinds of Column: name score \n");
        testString.append("Number of Data: 3\n");
        assertEquals(testString.toString(), outContent.toString().substring(0, outContent.size() - 37));
    }
}