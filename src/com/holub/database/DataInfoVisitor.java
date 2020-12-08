package com.holub.database;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class DataInfoVisitor implements ImporterVisitor {
    @Override
    public int visit(CSVImporter csv) {
        try{
            String target = csv.loadTableName() + "_Info_csv.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
            }
            else{
                BufferedReader in  = new BufferedReader(new FileReader(info));
                String line = null;
                while((line = in.readLine()) != null)
                    System.out.println(line);

            }
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
            String target = xml.loadTableName() + "_Info_xml.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.println(target + ": New database!!");
            }
            else{
                BufferedReader in  = new BufferedReader(new FileReader(info));
                String line = null;
                while((line = in.readLine()) != null)
                    System.out.println(line);

            }
        }
        catch (Exception e){
            System.out.println("File open failed");
        }
        finally {
            return 0;
        }
    }
}