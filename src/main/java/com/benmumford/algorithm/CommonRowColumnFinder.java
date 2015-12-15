package com.benmumford.algorithm;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

import org.springframework.stereotype.Component;

@Component
public class CommonRowColumnFinder implements ICommonRowColumnFinder {
    
    @Override
    public RowColumn findCommonRowColumn(List<RowColumn> rowColumns) {
        int length = rowColumns.get(0).getLength();
        RowColumn toReturn = new RowColumn(length);
        
        for (int i = 0; i < length; ++i) {
            Set<Cell> values = new HashSet<>();
            for (RowColumn rowColumn : rowColumns) {
                values.add(rowColumn.getValue(i));
            }
            
            if (values.size() == 1) {
                toReturn = toReturn.applyValue(i, values.iterator().next());
            }
        }
        
        return toReturn;
    }
}