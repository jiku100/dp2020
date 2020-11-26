package com.holub.database.jdbc;
import com.holub.database.CSVExporter;
import com.holub.database.HTMLExporter;
import com.holub.database.Table;
import com.holub.database.TableFactory;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class exporterTest {
    public static void main(String[] args) throws IOException {
        Table address = TableFactory.load("address.csv", "c:/dp2020");
        Writer writer = new FileWriter("c:/dp2020/test.html", false);
        address.export(new HTMLExporter(writer));
        writer.close();
    }
}
