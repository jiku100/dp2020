package com.holub.database;

import java.io.*;
import java.util.*;

public class HTMLExporter implements Table.Exporter
{	private final Writer out;
    private 	  int	 width;
    private       int    height;
    private String tableName;
    private ArrayList<String> columnNames = new ArrayList<String>();

    public HTMLExporter( Writer out )
    {	this.out = out;
    }

    public void storeMetadata( String tableName,
                               int width,
                               int height,
                               Iterator columnNames ) throws IOException

    {	this.width = width;
        this.height = height;
        this.tableName = tableName == null ? "anonymous" : tableName;
        while(columnNames.hasNext())
            this.columnNames.add(columnNames.next().toString());

        out.write("\t<head>\n");
        out.write("\t\t<title>");
        out.write(tableName == null ? "anonymous" : tableName );
        out.write("</title>\n");
        out.write("\t</head>\n");
        out.write("\t<body>\n");
        out.write("\t\t<table>\n");
        out.write("\t\t\t<thead>\n");
        out.write("\t\t\t\t<tr>\n");
        if(columnNames.hasNext()){
            out.write("\t\t\t\t\t<th>");
        }
        columnNames = this.columnNames.iterator();
        while( columnNames.hasNext() ) {
            Object datum = columnNames.next();
            out.write(datum.toString() + "</th>");
            if(columnNames.hasNext()){
                out.write("<th>");
            }
        }
        out.write("\n\t\t\t\t</tr>\n");
        out.write("\t\t\t</thead>\n");
        out.write("\t\t\t<tbody>\n");
    }

    public void storeRow( Iterator data ) throws IOException
    {
        if(data.hasNext()){
            out.write("\t\t\t\t<tr>");
        }
        while( data.hasNext() )
        {	Object datum = data.next();

            // Null columns are represented by an empty field
            // (two commas in a row). There's nothing to write
            // if the column data is null.
            if( datum != null ){
                out.write("<td>");
                out.write( datum.toString() );
                out.write("</td>");
            }
        }
        out.write("</tr>\n");
    }

    public void startTable() throws IOException {
        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
    }
    public void endTable()   throws IOException {
        out.write("\t\t\t</tbody>\n");
        out.write("\t\t</table>\n");
        out.write("\t</body>\n");
        out.write("</html>\n");
    }
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getTableName() {
        return this.tableName;
    }

    public ArrayList<String> getColumnNames() {
        return this.columnNames;
    }

    @Override
    public int accept(ExporterVisitor visitor) {
        return visitor.visit(this);
    }
}