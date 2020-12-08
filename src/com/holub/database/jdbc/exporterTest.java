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
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class exporterTest {
    public static void main(String[] args) throws IOException {
//        Table address = TableFactory.load("address.csv", "c:/dp2020");
//        Writer writer = new FileWriter("c:/dp2020/" + address.name() +".html", false);
//        HTMLExporter html = new HTMLExporter(writer);
//        address.export(html);
//        writer.close();
//        Map<ArrayList, ArrayList> a = new TreeMap<>();
//        ArrayList Key = new ArrayList();
//        ArrayList value = new ArrayList();
//        Key.add("1");
//        Key.add("2");
//        value.add("Hi");
//        a.put(Key, value);
//        Key.add("1");
//        Key.add("1");
//        value.add("Hello");
        Writer writer = new FileWriter("c:/dp2020/testFile/test.xml", false);
        XMLExporter exporter = new XMLExporter(writer);
        String testTableName = "student";
        ArrayList columnNames = new ArrayList();
        columnNames.add("name");
        columnNames.add("score");
        exporter.startTable();
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
        exporter.endTable();
        writer.close();
    }
}
