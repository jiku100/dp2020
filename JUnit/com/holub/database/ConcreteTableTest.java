package com.holub.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteTableTest {

    @Test
    void select() {
        String[] studentColumnNames = new String[]{"name", "score"};
        Table student = new ConcreteTable("student", studentColumnNames);

        String[] bankColumnNames = new String[]{"id", "password", "money"};
        Table bank = new ConcreteTable("bank", bankColumnNames);
        String[] requestedColumns = null;
        Table[] otherTables = new Table[]{bank};
        Selector where = Selector.ALL;
        Table testTable = student.select(where, requestedColumns, otherTables);
        Cursor rows = testTable.rows();

        String[] targetColumnName = new String[]{"name", "score", "id", "password", "money"};
        assertEquals(5, rows.columnCount());

        for(int i = 0; i<rows.columnCount(); i++)
            assertEquals(targetColumnName[i], rows.columnName(i));
    }
}