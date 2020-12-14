HolubSQL.jar
Version 1.0
Released 27 Sept., 2004

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

Released 14th Dec. 2020
Additional features
1. HTML Exporter: (src/com/holub/database/HTMLExporter.java)
2. XML Exporter: (src/com/holub/database/XMLExporter.java)
3. XML Importer: (src/com/holub/database/XMLImporter.java)
4. Join Error Fix:  (src/com/holub/database/ConcreteTable.java)
5. CheckEdit, WriteInfo, DataInfo features: 
(src/com/holub/database/CheckEditVisitor.java, WriteInfoVisitor.java, 
DataInfoVisitor.java, ImporterVisitor.java, ExporterVisitor.java)
6. SQL distinct Keyword:
(src/com/holub/database/ProcessedTable.java, ProcessOption.java,
rawTable.java, distinctProcess.java)
7. SQL order by Keyword: (src/com/holub/database/orderProcess.java)
8. Bug Fix on Less than, Bigger than operation on where Keyword:
(src/com/holub/database/Database.java)

Some Database file
1. address.csv
2. address_html.html
3. address_xml.xml
4. name.csv
5. name.html
6. name.xml
7. name_test.csv
8. ./testFile/student.csv
9. ./testFile/student.xml

Some Info file
1. address_Info_csv.txt
2. address_xml_Info_xml.txt
3. name_Info_csv.txt
4. name_Info_xml.txt
5. name_Info_html.txt
6. student_Info_csv.txt
7. student_Info_xml.txt
8. student_Info_html.txt

These files are products on testing