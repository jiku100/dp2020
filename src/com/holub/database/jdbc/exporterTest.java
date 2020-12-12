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
        Table address = TableFactory.load("name.csv", "c:/dp2020");
        Writer writer = new FileWriter("c:/dp2020/" + address.name() +".html", false);
        HTMLExporter html = new HTMLExporter(writer);
        address.export(html);
        writer.close();
    }
}
