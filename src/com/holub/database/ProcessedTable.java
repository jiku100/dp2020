package com.holub.database;

public abstract class ProcessedTable {
    public abstract void setRawTable(Table table);
    public abstract Table process();
}
