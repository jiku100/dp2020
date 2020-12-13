package com.holub.database;

public interface ImporterAcceptor {
    int accept(ImporterVisitor visitor);
}
