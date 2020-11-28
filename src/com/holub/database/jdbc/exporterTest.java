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
import java.util.StringTokenizer;


public class exporterTest {
    public static void main(String[] args) throws IOException {
//        Table address = TableFactory.load("xml_test.xml", "c:/dp2020");
//        Writer writer = new FileWriter("c:/dp2020/" + address.name() +".xml", false);
//        XMLExporter xml = new XMLExporter(writer);
//        address.export(xml);
//        xml.accept(new get());
//        writer.close();

//        Table address_csv = TableFactory.load("address.csv", "c:/dp2020");
        Table address_xml = TableFactory.load("xml_test.xml", "c:/dp2020");

//        File file = new File("address_Info_csv.txt");
//        if(file.exists()){
//            System.out.println("exists");
//        }
//        BufferedReader in  = new BufferedReader(new FileReader(file));
//        String test = in.readLine();
//        System.out.println(test);
//        if(test.endsWith("csv"))
//            System.out.println("!!!");
//        test = in.readLine();
//        test = in.readLine();
//        System.out.println(test);
//        test = in.readLine();
//        CSVImporter csv =  new CSVImporter(new FileReader(new File("address.csv")));
//        csv.startTable();
//        System.out.println(csv.loadWidth());
//        System.out.println(Integer.valueOf(test.substring(18, test.length())));
//
//        if(csv.loadWidth() == Integer.valueOf(test.substring(18, test.length()))){
//            System.out.println("asdadasdas");
//        }
//        test = in.readLine();
//        System.out.println(test.substring(18, test.length()));
//
//        String[] a = test.substring(17, test.length()).split(" ");
//        ArrayIterator columns = (ArrayIterator) csv.loadColumnNames();
//        String[] b = (String[]) columns.toArray();
//
//        for(int i = 0; i<csv.loadWidth();i++){
//            if(!b[i].equals(a[i])){
//                System.out.println("Not Matched Column Names");
//            }
//        }
//        test = in.readLine();
//        System.out.println(test);
//
//        test = in.readLine();
//        System.out.println(test);
//    }
    }
}
