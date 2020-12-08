package com.holub.database;

public interface ExporterVisitor {
    int visit(CSVExporter csv);
    int visit(HTMLExporter html);
    int visit(XMLExporter xml);
}
