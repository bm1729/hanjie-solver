package com.benmumford.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RowColumnTests {
    
    private RowColumn target;
    
    @Before
    public void beforeEach() {
        target = new RowColumn(10);
    }
    
    @Test
    public void getLength() {
        Assert.assertEquals(10, target.getLength());
    }
    
    @Test
    public void constructor_expect_InitiallyNull() {
        for (int i = 0; i < target.getLength(); ++i) {
            Assert.assertEquals(Cell.NULL, target.getValue(i));
        }
    }
    
    @Test
    public void applyValue_expect_returnsNewRowColumn() {
        Assert.assertNotSame(target.applyValue(0, Cell.EMPTY), target);
    }
    
    @Test
    public void applyValue_expect_valueSet() {
        target = target.applyValue(0, Cell.EMPTY);
        Assert.assertSame(Cell.EMPTY, target.getValue(0));
    }
}