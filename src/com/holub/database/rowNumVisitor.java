package com.holub.database;

public class rowNumVisitor implements ImporterVisitor{

    @Override
    public int visit(CSVImporter csv) {
        try{
            return csv.loadHeight();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int visit(XMLImporter xml) {
        try{
            return xml.loadHeight();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
