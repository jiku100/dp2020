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
        Table address = TableFactory.load("xml_test.xml", "c:/dp2020");
        Writer writer = new FileWriter("c:/dp2020/test.csv", false);
        address.export(new CSVExporter(writer));
        writer.close();
    }
}
