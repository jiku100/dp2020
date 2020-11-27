package com.holub.database;

import java.io.*;
import java.util.*;

public class HTMLExporter implements Table.Exporter, ExporterAccept
{	private final Writer out;
    private 	  int	 width;
    private       int    height;
    private String tableName;
    private String[] columnNames;

    public HTMLExporter( Writer out )
    {	this.out = out;
    }

    public void storeMetadata( String tableName,
                               int width,
                               int height,
                               Iterator columnNames ) throws IOException

    {	this.width = width;
        this.tableName = tableName == null ? "anonymous" : tableName;
        this.columnNames = new String[width];
        for(int i = 0; columnNames.hasNext(); i++){
            this.columnNames[i] = columnNames.next().toString();
        }

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
        out.write("\t\t\t<tbody>\n");
        System.out.print("\t\t\t<tbody>\n");
        storeRow( columnNames ); // comma separated list of columns ids
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

    @Override
    public void accept(ExporterVisitor visitor) {
        visitor.visit(this, this.tableName, this.width, this.height, this.columnNames);
    }
}