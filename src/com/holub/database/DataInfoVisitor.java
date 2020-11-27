package com.holub.database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataInfoVisitor implements ExporterVisitor {
    private void printDataInfo(Writer out, String tableName, int width, int height, String[] columnNames) throws IOException {
        SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        out.write("Number of Column: " + width + "\n");
        out.write("Kinds of Column: ");
        for(var s: columnNames){
            out.write(s + " ");
        }
        out.write("\n");
        out.write("Number of Data: " + height + "\n");
        out.write("Last Edit Time: " + timeFormat.format(time));
    }
    @Override
    public void visit(CSVExporter csv, String tableName, int width, int height, String[] columnNames) {
        String target = tableName + "Info_csv.txt";

        try {
            Writer out = new FileWriter(target, false);
            out.write("File Type: csv\n");
            out.write("Data File name: " + tableName + ".csv\n");
            printDataInfo(out, tableName, width, height, columnNames);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void visit(XMLExporter xml, String tableName, int width, int height, String[] columnNames) {
        String target = tableName + "Info_xml.txt";
        try {
            Writer out = new FileWriter(target, false);
            out.write("File Type: xml\n");
            out.write("Data File name: " + tableName + ".xml\n");
            printDataInfo(out, tableName, width, height, columnNames);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void visit(HTMLExporter html, String tableName, int width, int height, String[] columnNames) {
        String target = tableName + "Info_html.txt";
        try {
            Writer out = new FileWriter(target, false);
            out.write("File Type: html\n");
            out.write("Data File name: " + tableName + ".html\n");
            printDataInfo(out, tableName, width, height, columnNames);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
