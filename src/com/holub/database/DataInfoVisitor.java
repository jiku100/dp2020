package com.holub.database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class DataInfoVisitor implements ImporterVisitor {
    private void printData(Writer out, Table.Importer importer) throws IOException {
        out.write("Table Name: " + importer.loadTableName() +"\n");
        out.write("Number of Column: " + importer.loadWidth() + "\n");
        out.write("Kinds of Column: ");
        Iterator columns = importer.loadColumnNames();
        while(columns.hasNext())
            out.write(columns.next() + " ");
        out.write("\n");
    }

    @Override
    public int visit(CSVImporter csv) {
        try{
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            String target = csv.loadTableName() + "_Info_csv.txt";
            Writer out = new FileWriter(target, false);
            out.write("File Type: csv\n");
            out.write("Data File name: " + csv.loadTableName() + ".csv\n");
            printData(out, csv);
            out.write("Number of Data: " + csv.accept(new rowNumVisitor()) + "\n");
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
    public int visit(XMLImporter xml) {
        try{
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date();
            String target = xml.loadTableName() + "_Info_xml.txt";
            Writer out = new FileWriter(target, false);
            out.write("File Type: xml\n");
            out.write("Data File name: " + xml.loadTableName() + ".xml\n");
            printData(out, xml);
            out.write("Number of Data: " + xml.accept(new rowNumVisitor()) + "\n");
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