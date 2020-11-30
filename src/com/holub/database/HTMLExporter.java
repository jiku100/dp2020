package com.holub.database;

import java.io.*;
import java.util.*;

public class HTMLExporter implements Table.Exporter
{	private final Writer out;
    private 	  int	 width;
    private String tableName;

    public HTMLExporter( Writer out )
    {	this.out = out;
    }

    public void storeMetadata( String tableName,
                               int width,
                               int height,
                               Iterator columnNames ) throws IOException

    {	this.width = width;
        this.tableName = tableName == null ? "anonymous" : tableName;

        out.write("\t<head>\n");
        System.out.print("\t<head>\n");
        out.write("\t\t<title>");
        System.out.print("\t\t<title>");
        out.write(tableName == null ? "anonymous" : tableName );
        System.out.print(tableName == null ? "anonymous" : tableName );
        out.write("</title>\n");
        System.out.print("</title>\n");
        out.write("\t</head>\n");
        System.out.print("\t</head>\n");
        out.write("\t<body>\n");
        System.out.print("\t<body>\n");
        out.write("\t\t<table>\n");
        System.out.print("\t\t<table>\n");
        out.write("\t\t\t<thead>\n");
        System.out.print("\t\t\t<thead>\n");
        out.write("\t\t\t\t<tr>\n");
        System.out.print("\t\t\t\t<tr>\n");
        if(columnNames.hasNext()){
            out.write("\t\t\t\t\t<th>");
            System.out.print("\t\t\t\t\t<th>");
        }
        while( columnNames.hasNext() ) {
            Object datum = columnNames.next();
            out.write(datum.toString() + "</th>");
            System.out.print(datum.toString() + "</th>");
            if(columnNames.hasNext()){
                out.write("<th>");
                System.out.print("<th>");
            }
        }
        out.write("\n\t\t\t\t</tr>\n");
        System.out.print("\n\t\t\t\t</tr>\n");
        out.write("\t\t\t</thead>\n");
        System.out.print("\t\t\t</thead>\n");
        out.write("\t\t\t<tbody>\n");
        System.out.print("\t\t\t<tbody>\n");
    }

    public void storeRow( Iterator data ) throws IOException
    {	int i = width;
        if(data.hasNext()){
            out.write("\t\t\t\t<tr>");
            System.out.print("\t\t\t\t<tr>");
        }
        while( data.hasNext() )
        {	Object datum = data.next();

            // Null columns are represented by an empty field
            // (two commas in a row). There's nothing to write
            // if the column data is null.
            if( datum != null ){
                out.write("<td>");
                System.out.print("<td>");
                out.write( datum.toString() );
                System.out.print(datum.toString());
            }

            if( --i > 0 ){
                out.write("</td>");
                System.out.print("</td>");
            }
        }
        out.write("</tr>\n");
        System.out.print("</tr>\n");
    }

    public void startTable() throws IOException {
        out.write("<!DOCTYPE html>\n");
        System.out.print("<!DOCTYPE html>\n");
        out.write("<html>\n");
        System.out.print("<html>\n");
    }
    public void endTable()   throws IOException {
        out.write("\t\t\t</tbody>\n");
        System.out.print("\t\t\t</tbody>\n");
        out.write("\t\t</table>\n");
        System.out.print("\t\t</table>\n");
        out.write("\t</body>\n");
        System.out.print("\t</body>\n");
        out.write("</html>\n");
        System.out.print("</html>\n");
    }
}