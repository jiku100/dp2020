package com.holub.database.jdbc;

import com.holub.database.*;

import java.io.*;
import java.util.Iterator;


public class exporterTest {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("name.xml");
        XMLImporter xml = new XMLImporter(in);
        xml.startTable();
        System.out.println(xml.loadTableName());
        Iterator columns = xml.loadColumnNames();
        while(columns.hasNext())
            System.out.print(columns.next().toString() + " ");
        System.out.println();
        while ((columns = xml.loadRow()) != null){
            for( int i = 0; columns.hasNext();)
                System.out.print(columns.next().toString() + " ");
            System.out.println();
        }
        xml.endTable();
    }
}
