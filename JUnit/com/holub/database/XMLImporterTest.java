package com.holub.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;

import javax.sql.rowset.spi.XmlReader;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class XMLImporterTest {
    class testVisitor implements ImporterVisitor {

        @Override
        public int visit(CSVImporter csv) {
            return 1;
        }

        @Override
        public int visit(XMLImporter xml) {
            return 2;
        }
    }

    Reader in;
    XMLImporter importer;
    @BeforeEach
    public void init() throws FileNotFoundException {
        this.in = new FileReader("c:/dp2020/testFile/student.xml");
        this.importer = new XMLImporter(in);
    }
    @Test
    void startTable() throws IOException {
        importer.startTable();
        assertEquals(importer.loadTableName(), "student");
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        Iterator targetColumnNames = columnNames.iterator();
        Iterator tableColumnNames = importer.loadColumnNames();
        while(targetColumnNames.hasNext())
            assertEquals(tableColumnNames.next(), targetColumnNames.next());
    }

    @Test
    void loadTableName() throws IOException {
        importer.startTable();
        assertEquals(importer.loadTableName(), "student");
    }

    @Test
    void loadWidth() throws IOException {
        importer.startTable();
        assertEquals(importer.loadWidth(), 2);
    }

    @Test
    void loadHeight() throws IOException {
        importer.startTable();
        assertEquals(importer.loadHeight(), 3);
    }

    @Test
    void loadColumnNames() throws IOException {
        importer.startTable();
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        Iterator target = columnNames.iterator();
        Iterator test = importer.loadColumnNames();
        assertTrue(test.hasNext());
        while(test.hasNext())
            assertEquals(target.next(), test.next());
    }

    @Test
    void loadRow() throws IOException {
        importer.startTable();
        ArrayList<String> targetRows = new ArrayList<String>();
        targetRows.add("Shin");
        targetRows.add("4.5");
        targetRows.add("Seok");
        targetRows.add("3.8");
        targetRows.add("Gyeong");
        targetRows.add("4.2");
        Iterator target = targetRows.iterator();
        Iterator row = null;
        while((row = importer.loadRow()) != null){
            while(row.hasNext() && target.hasNext()){
                assertEquals(row.next(), target.next());
            }
        }
    }

    @Test
    void endTable() {}

    @Test
    void accept() {
        ImporterVisitor testvisitor = new testVisitor();
        int test = testvisitor.visit(new XMLImporter(in));
        assertEquals(2, test);
    }
}

