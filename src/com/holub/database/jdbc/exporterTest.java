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

//    try {
//        // 절대 경로로 xml 값을 얻어온다.
//        InputSource is = new InputSource(reader);
//
//        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
//
//        xml.getDocumentElement().normalize();
//        // root element 취득
//        Element element = xml.getDocumentElement();
//        tableName = element.getNodeName();
//        System.out.println(tableName);
//        // child node 취득
//        NodeList list = element.getElementsByTagName(tableName);
//        System.out.println(list.getLength());
//
//        int length = 0;
//        if(list.getLength() > 0) {
//            for(int i=0; i<list.getLength(); i++) {
//                NodeList childList = list.item(i).getChildNodes();
//                if(childList.getLength() > 0) {
//                    for (int j = 0; j < childList.getLength(); j++) {
//                        if(childList.item(j).getNodeName().equals("#text")==false) {
//                            length++;
//                            System.out.println("\t xml tag name : " + childList.item(j).getNodeName() + ", xml값 : "+childList.item(j).getTextContent());
//                        }
//                    }
//                }
//            }
//        }
//        int width = length / list.getLength();
//        columnNames = new String[width];
//        int i = 0;
//        NodeList childList = list.item(0).getChildNodes();
//        if(childList.getLength() > 0) {
//            for (int j = 0; j < childList.getLength(); j++) {
//                if(childList.item(j).getNodeName().equals("#text")==false) {
//                   columnNames[i++] = childList.item(j).getNodeName();
//                }
//            }
//        }
//
//        for(var s : columnNames){
//            System.out.println(s);
//        }
//
//    } catch (Exception e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
    }
}
