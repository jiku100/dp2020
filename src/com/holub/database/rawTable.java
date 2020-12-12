package com.holub.database;

public class rawTable extends ProcessedTable{
    private Table table;
    public rawTable() {}
    public rawTable(Table table) {this.table = table;}

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public void setRawTable(Table table) {
        setTable(table);
    }

    @Override
    public Table process() {
        return this.table;
    }
}
