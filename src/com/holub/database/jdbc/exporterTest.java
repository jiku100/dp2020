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
//        HTMLExporter xml = new HTMLExporter(writer);
//        address.export(xml);
//        writer.close();
        Map<ArrayList, ArrayList> a = new TreeMap<>();
        ArrayList Key = new ArrayList();
        ArrayList value = new ArrayList();
        Key.add("1");
        Key.add("2");
        value.add("Hi");
        a.put(Key, value);
        Key.add("1");
        Key.add("1");
        value.add("Hello");

    }
}
