package com.holub.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class CheckEditVisitor implements ExporterVisitor {
    @Override
    public int visit(CSVExporter csv) {
        try{
            String target = csv.getTableName() + "_Info_csv.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("csv")){
                System.out.println(target + ": Wrong Info File Type");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(csv.getTableName())){
                System.out.println(target + ": Wrong Table Name");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(csv.getWidth() != parseInt){
                System.out.println(target + ": Edited Columns Number " + parseInt + " -> " + csv.getWidth());
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = csv.getColumnNames().toArray(String[]::new);
            for(int i = 0; i<csv.getWidth();i++){
                if(!columns[i].equals(colunmsInfo[i])){
                    System.out.println(target + ": Edited Column Names" + colunmsInfo[i] + " -> " + columns[i]);
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(csv.getHeight() != parseInt){
                System.out.println(target + ": Edited Data Number" + parseInt + " -> " + csv.getHeight());
            }
        }catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }

    @Override
    public int visit(HTMLExporter html) {
        try{
            String target = html.getTableName() + "_Info_html.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("html")){
                System.out.println(target + ": Wrong Info File Type");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(html.getTableName())){
                System.out.println(target + ": Wrong Table Name");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(html.getWidth() != parseInt){
                System.out.println(target + ": Edited Columns Number " + parseInt + " -> " + html.getWidth());
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = html.getColumnNames().toArray(String[]::new);
            for(int i = 0; i<html.getWidth();i++){
                if(!columns[i].equals(colunmsInfo[i])){
                    System.out.println(target + ": Edited Column Names" + colunmsInfo[i] + " -> " + columns[i]);
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(html.getHeight() != parseInt){
                System.out.println(target + ": Edited Data Number" + parseInt + " -> " + html.getHeight());
            }
        }catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }

    @Override
    public int visit(XMLExporter xml) {
        try{
            String target = xml.getTableName() + "_Info_xml.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("xml")){
                System.out.println(target + ": Wrong Info File Type");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(xml.getTableName())){
                System.out.println(target + ": Wrong Table Name");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(xml.getWidth() != parseInt){
                System.out.println(target + ": Edited Columns Number " + parseInt + " -> " + xml.getWidth());
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = xml.getColumnNames().toArray(String[]::new);
            for(int i = 0; i<xml.getWidth();i++){
                if(!columns[i].equals(colunmsInfo[i])){
                    System.out.println(target + ": Edited Column Names" + colunmsInfo[i] + " -> " + columns[i]);
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(xml.getHeight() != parseInt){
                System.out.println(target + ": Edited Data Number" + parseInt + " -> " + xml.getHeight());
            }
        }catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }
}
