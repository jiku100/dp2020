package com.holub.database;

public interface ExporterAccept {
    int accept(ExporterVisitor visitor);
}
