package com.holub.database;

public class distinctProcess extends ProcessOption {
    public distinctProcess(ProcessedTable processedTable){
        this.processedTable = processedTable;
    }

    @Override
    public void setRawTable(Table table) {
        processedTable.setRawTable(table);
    }

    @Override
    public Table process() {
        Table table = processedTable.process();
        Cursor rows = table.rows();
        int i = 0;
        int numOverlapRow;
        int numOverlapCol;
        while (rows.advance()) {
            numOverlapRow = 0;
            i++;

            Cursor targetRows = table.rows();
            for (int j = 0; j < i; j++) {
                targetRows.advance();

                numOverlapCol = 0;
                for (int k = 0; k < rows.columnCount(); k++) {
                    String value1 = rows.column(rows.columnName(k)) == null ? "null" : rows.column(rows.columnName(k)).toString();
                    String value2 = targetRows.column(targetRows.columnName(k)) == null ? "null" : targetRows.column(targetRows.columnName(k)).toString();
                    if (value1.equals(value2))
                        numOverlapCol++;
                }
                if (numOverlapCol == targetRows.columnCount()) {
                    numOverlapRow++;
                }
            }
            if(numOverlapRow > 1){
                rows.delete();
                rows = table.rows();
                i = 0;
            }
        }
        return table;
    }
}
