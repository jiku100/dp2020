package com.holub.database;

import com.holub.tools.ArrayIterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class CheckEditVisitor implements ImporterVisitor {
    @Override
    public int visit(CSVImporter csv) {
        try{
            String target = csv.loadTableName() + "_Info_csv.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("csv")){
                System.out.println(target + ": Wrong Info File Type");
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(csv.loadTableName())){
                System.out.println(target + ": Edited Table Name");
            }
            line = in.readLine();
            if(Integer.valueOf(line.substring(18, line.length())) != csv.loadWidth()){
                System.out.println(target + ": Edited Columns Number");
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            ArrayIterator columns_iter = (ArrayIterator) csv.loadColumnNames();
            String[] columns = (String[]) columns_iter.toArray();
            for(int i = 0; i<csv.loadWidth();i++){
                if(!columns[i].equals(colunmsInfo[i])){
                    System.out.println(target + ": Edited Column Names");
                }
            }

            line = in.readLine();
            if(Integer.valueOf(line.substring(16, line.length())) != csv.loadHeight()){
                System.out.println(target + ": Edited Data Number");
            }

        }catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }

    @Override
    public int visit(XMLImporter xml) {
        try{
            String target = xml.loadTableName() + "_Info_xml.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
            }
            BufferedReader in  = new BufferedReader(new FileReader(info));
            String line = in.readLine();
            if(!line.endsWith("xml")){
                System.out.println(target + ": Wrong Info File Type");
            }
            line = in.readLine();
            line = in.readLine();
            if(!line.endsWith(xml.loadTableName())){
                System.out.println(target + ": Edited Table Name");
            }
            line = in.readLine();
            if(Integer.valueOf(line.substring(18, line.length())) != xml.loadWidth()){
                System.out.println(target + ": Edited Columns Number");
            }
            line = in.readLine();
            String[] colunmsInfo = line.substring(17, line.length()).split(" ");
            ArrayIterator columns_iter = (ArrayIterator) xml.loadColumnNames();
            String[] columns = (String[]) columns_iter.toArray();
            for(int i = 0; i<xml.loadWidth();i++){
                if(!columns[i].equals(colunmsInfo[i])){
                    System.out.println(target + ": Edited Column Names");
                }
            }

            line = in.readLine();
            if(Integer.valueOf(line.substring(16, line.length())) != xml.loadHeight()){
                System.out.println(target + ": Edited Data Number");
            }

        }catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }
}
