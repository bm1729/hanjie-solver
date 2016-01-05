package com.benmumford.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import com.benmumford.TestUtils;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

public class CandidateRowColumnTrimmerTests {
    
    private CandidateRowColumnTrimmer target;
    
    @Before
    public void beforeEach() {
        target = new CandidateRowColumnTrimmer();
    }
    
    @Test
    public void trimCandidates() {
        ArrayList<RowColumn> candidates = new ArrayList<>();
        RowColumn passingCandidate1 = TestUtils.createRowColumn(Cell.EMPTY, Cell.FULL, Cell.EMPTY);
        RowColumn passingCandidate2 = TestUtils.createRowColumn(Cell.EMPTY, Cell.FULL, Cell.FULL);
        candidates.add(TestUtils.createRowColumn(Cell.EMPTY, Cell.EMPTY, Cell.EMPTY));
        candidates.add(TestUtils.createRowColumn(Cell.EMPTY, Cell.EMPTY, Cell.FULL));
        candidates.add(passingCandidate1);
        candidates.add(passingCandidate2);
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.EMPTY, Cell.EMPTY));
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.EMPTY, Cell.FULL));
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.FULL, Cell.EMPTY));
        candidates.add(TestUtils.createRowColumn(Cell.FULL, Cell.FULL, Cell.FULL));
        
        List<RowColumn> result = target.trimCandidates(candidates, TestUtils.createRowColumn(Cell.EMPTY, Cell.FULL, Cell.NULL));
        
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(passingCandidate1, result.get(0));
        Assert.assertEquals(passingCandidate2, result.get(1));
    }
}