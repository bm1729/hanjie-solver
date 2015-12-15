package com.benmumford.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridTests {
    
    private Grid target;
    
    @Before
    public void beforeEach() {
        target = new Grid(10, 5); // 10 rows, 5 columns
    }
    
    @Test
    public void getNumberOfRows() {
        Assert.assertEquals(10, target.getNumberOfRows());
    }
    
    @Test
    public void getNumberOfColumns() {
        Assert.assertEquals(5, target.getNumberOfColumns());
    }
    
    @Test
    public void applyRow_expect_returnsNewGrid() {
        Assert.assertNotSame(target.applyRow(0, new RowColumn(target.getNumberOfColumns())), target);
    }
    
    @Test
    public void applyRow_expect_valueSet() {
        RowColumn newRow = new RowColumn(target.getNumberOfColumns()).applyValue(2, Cell.FULL);
        target = target.applyRow(3, newRow);
        
        Assert.assertNotSame(Cell.FULL, target.getRow(2).getValue(3));
        Assert.assertNotSame(Cell.FULL, target.getColumn(3).getValue(2));
    }
    
    @Test
    public void applyColumn_expect_returnsNewGrid() {
        Assert.assertNotSame(target.applyColumn(0, new RowColumn(target.getNumberOfRows())), target);
    }
    
    @Test
    public void applyColumn_expect_valueSet() {
        RowColumn newColumn = new RowColumn(target.getNumberOfRows()).applyValue(2, Cell.FULL);
        target = target.applyColumn(3, newColumn);
        
        Assert.assertNotSame(Cell.FULL, target.getColumn(2).getValue(3));
        Assert.assertNotSame(Cell.FULL, target.getRow(3).getValue(2));
    }
}