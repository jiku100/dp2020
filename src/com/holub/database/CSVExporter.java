/*  (c) 2004 Allen I. Holub. All rights reserved.
 *
 *  This code may be used freely by yourself with the following
 *  restrictions:
 *
 *  o Your splash screen, about box, or equivalent, must include
 *    Allen Holub's name, copyright, and URL. For example:
 *
 *      This program contains Allen Holub's SQL package.<br>
 *      (c) 2005 Allen I. Holub. All Rights Reserved.<br>
 *              http://www.holub.com<br>
 *
 *    If your program does not run interactively, then the foregoing
 *    notice must appear in your documentation.
 *
 *  o You may not redistribute (or mirror) the source code.
 *
 *  o You must report any bugs that you find to me. Use the form at
 *    http://www.holub.com/company/contact.html or send email to
 *    allen@Holub.com.
 *
 *  o The software is supplied <em>as is</em>. Neither Allen Holub nor
 *    Holub Associates are responsible for any bugs (or any problems
 *    caused by bugs, including lost productivity or data)
 *    in any of this code.
 */
package com.holub.database;

import java.io.*;
import java.util.*;

/***
 *	Pass this exporter to a {@link Table#export} implementation to
 *	create a comma-sparated-value version of a {@link Table}.
 *	For example:
 *	<PRE>
 *	Table people  = TableFactory.create( ... );
 *	//...
 *	Writer out = new FileWriter( "people.csv" );
 *	people.export( new CSVExporter(out) );
 *	out.close();
 *	</PRE>
 *	The output file for a table called "name" with
 *	columns "first," "last," and "addrId" would look
 *	like this:
 *	<PRE>
 *	name
 *	first,	last,	addrId
 *	Fred,	Flintstone,	1
 *	Wilma,	Flintstone,	1
 *	Allen,	Holub,	0
 *	</PRE>
 *	The first line is the table name, the second line
 *	identifies the columns, and the subsequent lines define
 *	the rows.
 *
 * @include /etc/license.txt
 * @see Table
 * @see Table.Exporter
 * @see CSVImporter
 */

public class CSVExporter implements Table.Exporter
{	private final Writer out;
	private 	  int	 width;
	private       int    height;
	private String tableName;
	private ArrayList<String> columnNames = new ArrayList<String>();
	public CSVExporter( Writer out )
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

		out.write(tableName == null ? "<anonymous>" : tableName );
		out.write("\n");
		storeRow( this.columnNames.iterator() ); // comma separated list of columns ids
	}

	public void storeRow( Iterator data ) throws IOException
	{	int i = width;
		while( data.hasNext() )
		{	Object datum = data.next();

			// Null columns are represented by an empty field
			// (two commas in a row). There's nothing to write
			// if the column data is null.
			if( datum != null )	
				out.write( datum.toString() );
			else
				out.write("null");

			if( --i > 0 )
				out.write(",\t");
		}
		out.write("\n");
	}

	public void startTable() throws IOException {/*nothing to do*/}
	public void endTable()   throws IOException {/*nothing to do*/}
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
