package com.holub.database.jdbc;
import com.holub.database.CSVExporter;
import com.holub.database.HTMLExporter;
import com.holub.database.Table;
import com.holub.database.TableFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
//        Table address = TableFactory.load("address.csv", "c:/dp2020");
//        Writer writer = new FileWriter("c:/dp2020/test.html", false);
//        address.export(new HTMLExporter(writer));
//        writer.close();

    try {
        // 절대 경로로 xml 값을 얻어온다.
        InputSource is = new InputSource(new FileReader("xml_test.xml"));

        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

        // root element 취득
        Element element = xml.getDocumentElement();
        System.out.println(element.getTagName());
        // child node 취득
        NodeList list = element.getChildNodes();

        // child node 가 1개 이상인 경우
        if(list.getLength() > 0) {
            for(int i=0; i<list.getLength(); i++) {
                if(list.item(i).getNodeName().equals("#text")==false)
                    System.out.println(list.item(i));
                //NodeList childList = list.item(i).getChildNodes();

//                if(childList.getLength() > 0) {
//                    for (int j = 0; j < childList.getLength(); j++) {
//                        System.out.println(childList.item(j).());
//                        // 데이터가 있는 애들만 출려되게 한다.
////                        if(childList.item(j).getNodeName().equals("addrId")==false) {
////                            System.out.println("\t xml tag name : " + childList.item(j).getNodeName() + ", xml값 : "+childList.item(j).getTextContent());
////                        }
//                    }
//                }
//                System.out.println();
            }
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
