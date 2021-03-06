package com.holub.database;

import com.holub.tools.ArrayIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

public class XMLImporter implements Table.Importer
{	private BufferedReader  in;			// null once end-of-file reached
    private String[]        columnNames;
    private String          tableName;
    private NodeList    list;
    private int     width;
    private int   num;
    public XMLImporter( Reader in )
    {	this.in = in instanceof BufferedReader
            ? (BufferedReader)in
            : new BufferedReader(in);
    }
    public void startTable()			throws IOException
    {
        try {
            InputSource is = new InputSource(this.in);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            doc.getDocumentElement().normalize();
            // root element 취득
            Element element = doc.getDocumentElement();
            this.tableName = element.getNodeName();

            // child node 취득
            this.list = element.getElementsByTagName(tableName);
            ArrayList<String> columnNamesAry = new ArrayList<String>();
            if(list.getLength() > 0) {
                NodeList childList = list.item(0).getChildNodes();
                if(childList.getLength() > 0) {
                    for (int j = 0; j < childList.getLength(); j++) {
                        if(childList.item(j).getNodeName().equals("#text")==false) {
                            columnNamesAry.add(childList.item(j).getNodeName());
                            width++;
                        }
                    }
                }
            }
            this.columnNames = columnNamesAry.toArray(String[]::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String loadTableName()		throws IOException
    {	return tableName;
    }
    public int loadWidth()			    throws IOException
    {	return columnNames.length;
    }
    public int loadHeight()             throws IOException
    {   return list.getLength();
    }
    public Iterator loadColumnNames()	throws IOException
    {	return new ArrayIterator(columnNames);
    }

    public Iterator loadRow()			throws IOException
    {	Iterator row = null;
        if(num<list.getLength()){
            NodeList childList = list.item(num).getChildNodes();
            String[] value = new String[width];
            int i = 0;
            if(childList.getLength() > 0) {
                for (int j = 0; j < childList.getLength(); j++) {
                    if(childList.item(j).getNodeName().equals("#text")==false) {
                        value[i++] = childList.item(j).getTextContent();
                    }
                }
            }
            row = new ArrayIterator(value);
            num++;
        }
        return row;
    }

    public void endTable() throws IOException {}

    public int accept(ImporterVisitor visitor) {
        return visitor.visit(this);
    }
}