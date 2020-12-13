package com.holub.database;

import java.util.ArrayList;

public interface ExporterAcceptor {
    public int getWidth();
    public int getHeight();
    public String getTableName();
    public ArrayList<String> getColumnNames();
    public int accept(ExporterVisitor visitor);
}
