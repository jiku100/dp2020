package com.holub.database;

import java.io.*;
import java.util.*;

public class XMLExporter implements Table.Exporter
{	private final Writer out;
    private 	  int	 width;
    private       int    height;
    private String tableName;
    private ArrayList<String> columnNames = new ArrayList<String>();

    public XMLExporter( Writer out )
    {	this.out = out;
    }

    public void storeMetadata( String tableName,
                               int width,
                               int height,
                               Iterator columnNames ) throws IOException

    {	this.width = width;
        this.height = height;
        this.tableName = tableName == null ? "anonymous" : tableName;

        for(int i = 0; columnNames.hasNext(); i++){
            this.columnNames.add(columnNames.next().toString());
        }

        out.write("<" + this.tableName + ">\n");
    }

    public void storeRow( Iterator data ) throws IOException
    {	int i = 0;
        boolean hasText = false;
        if(data.hasNext()){
            hasText = true;
            out.write("\t<" + this.tableName + ">\n");
        }

        while( data.hasNext())
        {	Object datum = data.next();

            String temp = columnNames.get(i);
            out.write("\t\t<" + temp + ">");
            out.write( datum == null ? "null" : datum.toString());
            out.write("</" + temp + ">\n");

            if( i < width )
                i++;

        }
        if(hasText){
            out.write("\t</" + this.tableName + ">\n");
        }
    }

    public void startTable() throws IOException {
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    }
    public void endTable()   throws IOException {
        out.write("</" + this.tableName + ">\n");
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