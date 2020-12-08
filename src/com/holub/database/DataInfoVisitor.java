package com.holub.database;

import java.io.*;

public class DataInfoVisitor implements ImporterVisitor {
    @Override
    public int visit(CSVImporter csv) {
        try{
            String target = csv.loadTableName() + "_Info_csv.txt";
            File info = new File(target);
            if(!info.exists()){
                System.out.print(target + ": New database!!\n");
            }
            else{
                BufferedReader in  = new BufferedReader(new FileReader(info));
                String line = null;
                while((line = in.readLine()) != null)
                    System.out.print(line + "\n");
            }
            System.out.print("\n");
        }
        catch (Exception e){
            System.out.print("File open failed\n");
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
                System.out.print(target + ": New database!!\n");
            }
            else{
                BufferedReader in  = new BufferedReader(new FileReader(info));
                String line = null;
                while((line = in.readLine()) != null)
                    System.out.print(line + "\n");
            }
            System.out.print("\n");
        }
        catch (Exception e){
            System.out.print("File open failed\n");
        }
        finally {
            return 0;
        }
    }
}