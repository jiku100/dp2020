package com.holub.database;

import com.holub.text.ParseFailure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class orderProcessTest {
    static Database database;
    static StringBuilder testString;
    @BeforeAll
    static void setDatabase() throws IOException, ParseFailure {
        database = new Database("");
        database.createTable("number", Arrays.asList("first", "second", "third"));
        String[] first = new String[]{"0", "1", "0", "1", "1", "3", "3"};
        String[] second = new String[]{"1", "2", "2", "0", "1", "0", "1"};
        String[] third = new String[]{"1", "3", "2", "2", "1", "1", "3"};
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
        Table result = database.execute("select third, first, second from number");
        List columns = new ArrayList<>();
        columns.add("third");
        columns.add("first");
        columns.add("second");
        Map orderColumns = new LinkedHashMap<Integer, Integer>();
        String[] originalColumns = new String[]{"third"};
        orderColumns.put(1, 0); // first -> asc
        orderColumns.put(2, 1); // second -> desc
        ProcessedTable processedTable = new rawTable();
        processedTable = new orderProcess(processedTable, columns, orderColumns, originalColumns);
        processedTable.setRawTable(result);
        Table processed = processedTable.process();

        testString.append("<anonymous>\n");
        testString.append("third\t");
        testString.append("\n----------------------------------------\n");
        testString.append("2\t\n");
        testString.append("1\t\n");
        testString.append("3\t\n");
        testString.append("1\t\n");
        testString.append("2\t\n");
        testString.append("3\t\n");
        testString.append("1\t\n");
        assertEquals(testString.toString(), processed.toString());
    }
}