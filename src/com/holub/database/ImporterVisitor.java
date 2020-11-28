package com.holub.database;

public interface ImporterVisitor
{
    int visit(CSVImporter csv);
    int visit(XMLImporter xml);
}
