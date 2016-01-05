package com.benmumford;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

public class TestUtils {
    
    private TestUtils() {}
    
    public static RowColumn createRowColumn(Cell... cells) {
        RowColumn toReturn = new RowColumn(cells.length);
        for (int i = 0; i < cells.length; ++i) {
            toReturn = toReturn.applyValue(i, cells[i]);
        }
        
        return toReturn;
    }
}