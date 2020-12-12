package com.holub.database;

import com.holub.tools.Order;

import javax.xml.crypto.Data;
import java.beans.Expression;
import java.util.*;

public class orderProcess implements PostProcess {
    List columns;
    Map orderColumns;
    String[] originalColumns;
    public orderProcess(List columns, Map orderColumns, String[] originalColumns){
        this.columns = columns;
        this.orderColumns = orderColumns;
        this.originalColumns = originalColumns;
    }

    @Override
    public Table process(Table table) {
        Table orderTable = new ConcreteTable(null, originalColumns);
        Cursor rows = table.rows();
        List<Order> tempOrder = new ArrayList<Order>();
        while(rows.advance()){
            ArrayList row = new ArrayList();
            Iterator it_row = rows.columns();
            while(it_row.hasNext()){
                row.add(it_row.next());
            }
            tempOrder.add(new Order(orderColumns, row.toArray()));
        }
        Collections.sort(tempOrder);
        for(int i = 0; i<tempOrder.size();i++){
            Iterator row = tempOrder.get(i).getRow();
            String[] newRow = new String[originalColumns.length];
            for(int j = 0; j<originalColumns.length; j++){
                Object value = row.next();
                newRow[j] = value == null ? null : value.toString();
            }
            orderTable.insert(originalColumns, newRow);
        }
        return orderTable;
    }
}
