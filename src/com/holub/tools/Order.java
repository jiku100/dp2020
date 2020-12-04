package com.holub.tools;

import com.holub.database.Cursor;
import com.holub.database.Table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Order implements Comparable<Order>{
    private Map orderColumns;
    Object[] row;

    public Order(Map orderColumns, Object[] row){
        this.orderColumns = orderColumns;
        this.row = row;
    }

    public Object getColumn(int columnIdx){
        return row[columnIdx];
    }

    public Iterator getRow(){
        return new ArrayIterator(row);
    }
    @Override
    public int compareTo(Order o) {
        for(var columnIdx: orderColumns.keySet()){
            if(row[(int)columnIdx].equals(o.getColumn((int)columnIdx))){
                continue;
            }
            else{
                if((Integer)orderColumns.get(columnIdx) == 0){
                    return row[(int)columnIdx].toString().compareTo(o.getColumn((int)columnIdx).toString());
                }
                else{
                    return o.getColumn((int)columnIdx).toString().compareTo(row[(int)columnIdx].toString());
                }
            }
        }
        return 0;
    }
}
