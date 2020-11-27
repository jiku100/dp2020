package com.holub.database;

public interface ExporterVisitor {
    void visit(CSVExporter csv, String tableName, int width, int height, String[] columnNames);
    void visit(HTMLExporter html, String tableName, int width, int height, String[] columnNames);
    void visit(XMLExporter xml, String tableName, int width, int height, String[] columnNames);
}

