package com.holub.database.jdbc;
import com.holub.database.*;
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


public class exporterTest {
    public static void main(String[] args) throws IOException {
//        Table address = TableFactory.load("xml_test.xml", "c:/dp2020");
//        Writer writer = new FileWriter("c:/dp2020/" + address.name() +".xml", false);
//        XMLExporter xml = new XMLExporter(writer);
//        address.export(xml);
//        xml.accept(new get());
//        writer.close();
        Reader in = new FileReader( new File( "c:/dp2020", "address.csv" ));
        CSVImporter csv = new CSVImporter(in);
        System.out.println(csv.accept(new rowNumVisitor()));

        in = new FileReader( new File( "c:/dp2020", "xml_test.xml" ));
        XMLImporter xml = new XMLImporter(in);
        System.out.println(xml.accept(new rowNumVisitor()));

    }
}
