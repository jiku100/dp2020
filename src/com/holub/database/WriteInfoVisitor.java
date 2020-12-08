package com.holub.database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class WriteInfoVisitor implements ExporterVisitor{
    @Override
    public int visit(CSVExporter csv) {
        try{
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            String target = csv.getTableName() + "_Info_xml.txt";
            Writer out = new FileWriter(target, false);
            out.write("File Type: xml\n");
            out.write("Data File name: " + csv.getTableName() + ".xml\n");
            out.write("Table Name: " + csv.getTableName() +"\n");
            out.write("Number of Column: " + csv.getWidth() + "\n");
            out.write("Kinds of Column: ");
            ArrayList<String> columns = csv.getColumnNames();
            for(int i = 0; i<csv.getWidth();i++)
                out.write(columns.get(i) + " ");
            out.write("\n");
            out.write("Number of Data: " + csv.getHeight() + "\n");
            out.write("Last Edit Time: " + timeFormat.format(time));
            out.close();
        }
        catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }

    @Override
    public int visit(HTMLExporter html) {
        try{
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            String target = html.getTableName() + "_Info_xml.txt";
            Writer out = new FileWriter(target, false);
            out.write("File Type: xml\n");
            out.write("Data File name: " + html.getTableName() + ".xml\n");
            out.write("Table Name: " + html.getTableName() +"\n");
            out.write("Number of Column: " + html.getWidth() + "\n");
            out.write("Kinds of Column: ");
            ArrayList<String> columns = html.getColumnNames();
            for(int i = 0; i<html.getWidth();i++)
                out.write(columns.get(i) + " ");
            out.write("\n");
            out.write("Number of Data: " + html.getHeight() + "\n");
            out.write("Last Edit Time: " + timeFormat.format(time));
            out.close();
        }
        catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }

    @Override
    public int visit(XMLExporter xml) {
        try{
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            String target = xml.getTableName() + "_Info_xml.txt";
            Writer out = new FileWriter(target, false);
            out.write("File Type: xml\n");
            out.write("Data File name: " + xml.getTableName() + ".xml\n");
            out.write("Table Name: " + xml.getTableName() +"\n");
            out.write("Number of Column: " + xml.getWidth() + "\n");
            out.write("Kinds of Column: ");
            ArrayList<String> columns = xml.getColumnNames();
            for(int i = 0; i<xml.getWidth();i++)
                out.write(columns.get(i) + " ");
            out.write("\n");
            out.write("Number of Data: " + xml.getHeight() + "\n");
            out.write("Last Edit Time: " + timeFormat.format(time));
            out.close();
        }
        catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }
}
