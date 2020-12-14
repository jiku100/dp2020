package com.holub.database.jdbc;
import com.holub.database.*;
import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.*;
import java.util.*;


public class exporterTest {
    public static void main(String[] args) throws IOException {
//        Reader in = new FileReader("name.xml");
//        XMLImporter xml = new XMLImporter(in);
//        xml.startTable();
//        System.out.println(xml.loadTableName());
//        Iterator columns = xml.loadColumnNames();
//        while(columns.hasNext()){
//            System.out.print(columns.next().toString() + " ");
//        }
//        System.out.println();
//        while ((columns = xml.loadRow()) != null) {
//            for (int i = 0; columns.hasNext();)
//                System.out.print(columns.next().toString() + " ");
//            System.out.println();
//        }
//        xml.endTable();
        String s = "address_xml";
        if(s.endsWith("xml"))
            System.out.print("aa");
    }
}
