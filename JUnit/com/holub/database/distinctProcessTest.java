package com.holub.database;

import com.holub.text.ParseFailure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class distinctProcessTest {
    static Database database;
    static StringBuilder testString;
    @BeforeAll
    static void setDatabase() throws IOException, ParseFailure {
        database = new Database("");
        database.createTable("number", Arrays.asList("first", "second", "third"));
        String[] first = new String[]{"0", "1", "0", "1", "1", "3", "3"};
        String[] second = new String[]{"1", "1", "1", "0", "1", "0", "0"};
        String[] third = new String[]{"1", "2", "2", "2", "2", "0", "0"};
        for(int i = 0; i<first.length;i++){
            database.execute(String.format("INSERT INTO number VALUES(\"%s\", \"%s\", \"%s\")", first[i], second[i], third[i]));
        }
    }
    @BeforeEach
    void setTestSring(){
        testString = new StringBuilder();
    }

    @Test
    void process() throws IOException, ParseFailure {
        Table result = database.execute("select * from number");
        ProcessedTable processedTable = new rawTable();
        processedTable = new distinctProcess(processedTable);
        processedTable.setRawTable(result);
        Table processed = processedTable.process();

        testString.append("<anonymous>\n");
        testString.append("first\tsecond\tthird\t");
        testString.append("\n----------------------------------------\n");
        testString.append("0\t1\t1\t\n");
        testString.append("1\t1\t2\t\n");
        testString.append("0\t1\t2\t\n");
        testString.append("1\t0\t2\t\n");
        testString.append("3\t0\t0\t\n");

        assertEquals(testString.toString(), processed.toString());
    }
}