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
                System.out.print(target + ": New database!!\n");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("csv")){
                System.out.print(target + ": Wrong Info File Type\n");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(csv.getTableName())){
                System.out.print(target + ": Wrong Table Name\n");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(csv.getWidth() != parseInt){
                System.out.print(target + ": Edited Columns Number " + parseInt + " -> " + csv.getWidth() +"\n");
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = csv.getColumnNames().toArray(String[]::new);
            int i = 0;
            for(i = 0; i<csv.getWidth();i++){
                String targetColumn = (i < colunmsInfo.length) ? colunmsInfo[i] : null;
                if(targetColumn != null) {
                    if(!columns[i].equals(targetColumn)){
                        System.out.print(target + ": Edited Column Names " + targetColumn + " -> " + columns[i] +"\n");
                    }
                }
                else{
                    System.out.print(target + ": Add New Column Names -> " + columns[i] + "\n");
                }
            }
            if(i < colunmsInfo.length){
                for(; i<colunmsInfo.length; i++){
                    System.out.print(target + ": Delete Column Names -> " + colunmsInfo[i] + "\n");
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(csv.getHeight() != parseInt){
                System.out.print(target + ": Edited Data Number " + parseInt + " -> " + csv.getHeight() +"\n");
            }
        }catch (Exception e){
            System.out.print("File open failed\n");
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
                System.out.print(target + ": New database!!\n");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("html")){
                System.out.print(target + ": Wrong Info File Type\n");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(html.getTableName())){
                System.out.print(target + ": Wrong Table Name\n");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(html.getWidth() != parseInt){
                System.out.print(target + ": Edited Columns Number " + parseInt + " -> " + html.getWidth() +"\n");
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = html.getColumnNames().toArray(String[]::new);
            int i = 0;
            for(i = 0; i<html.getWidth();i++){
                String targetColumn = (i < colunmsInfo.length) ? colunmsInfo[i] : null;
                if(targetColumn != null) {
                    if(!columns[i].equals(targetColumn)){
                        System.out.print(target + ": Edited Column Names " + targetColumn + " -> " + columns[i] +"\n");
                    }
                }
                else{
                    System.out.print(target + ": Add New Column Names -> " + columns[i] + "\n");
                }
            }
            if(i < colunmsInfo.length){
                for(; i<colunmsInfo.length; i++){
                    System.out.print(target + ": Delete Column Names -> " + colunmsInfo[i] + "\n");
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(html.getHeight() != parseInt){
                System.out.print(target + ": Edited Data Number " + parseInt + " -> " + html.getHeight() +"\n");
            }
        }catch (Exception e){
            System.out.print("File open failed\n");
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
                System.out.print(target + ": New database!!\n");
                return 0;
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("xml")){
                System.out.print(target + ": Wrong Info File Type\n");
                return -1;
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(xml.getTableName())){
                System.out.print(target + ": Wrong Table Name\n");
                return -1;
            }
            line = in.readLine();
            int parseInt = Integer.parseInt(line.substring(18, line.length()));
            if(xml.getWidth() != parseInt){
                System.out.print(target + ": Edited Columns Number " + parseInt + " -> " + xml.getWidth() +"\n");
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            String[] columns = xml.getColumnNames().toArray(String[]::new);
            int i = 0;
            for(i = 0; i<xml.getWidth();i++){
                String targetColumn = (i < colunmsInfo.length) ? colunmsInfo[i] : null;
                if(targetColumn != null) {
                    if(!columns[i].equals(targetColumn)){
                        System.out.print(target + ": Edited Column Names " + targetColumn + " -> " + columns[i] +"\n");
                    }
                }
                else{
                    System.out.print(target + ": Add New Column Names -> " + columns[i] + "\n");
                }
            }
            if(i < colunmsInfo.length){
                for(; i<colunmsInfo.length; i++){
                    System.out.print(target + ": Delete Column Names -> " + colunmsInfo[i] + "\n");
                }
            }

            line = in.readLine();
            parseInt = Integer.parseInt(line.substring(16, line.length()));
            if(xml.getHeight() != parseInt){
                System.out.print(target + ": Edited Data Number " + parseInt + " -> " + xml.getHeight() +"\n");
            }
        }catch (Exception e){
            System.out.print("File open failed\n");
        }
        finally {
            return 0;
        }
    }
}
