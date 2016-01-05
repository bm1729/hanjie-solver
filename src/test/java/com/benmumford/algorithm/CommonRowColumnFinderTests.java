package com.benmumford.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import com.benmumford.TestUtils;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

public class CommonRowColumnFinderTests {
    
    private CommonRowColumnFinder target;
    
    @Before
    public void beforeEach() {
        target = new CommonRowColumnFinder();
    }
    
    private RowColumn createRowColumn(Cell... cells) {
        RowColumn toReturn = new RowColumn(cells.length);
        for (int i = 0; i < cells.length; ++i) {
            toReturn = toReturn.applyValue(i, cells[i]);
        }
        
        return toReturn;
    }
    
    @Test
    public void findCommonRowColumn() {
        ArrayList<RowColumn> candidates = new ArrayList<>();
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.EMPTY, Cell.FULL));
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.EMPTY, Cell.EMPTY));
        
        RowColumn result = target.findCommonRowColumn(candidates);
        
        Assert.assertEquals(Cell.FULL, result.getValue(0));
        Assert.assertEquals(Cell.EMPTY, result.getValue(1));
        Assert.assertEquals(Cell.NULL, result.getValue(2));
    }
}