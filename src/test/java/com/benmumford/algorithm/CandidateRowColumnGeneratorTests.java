package com.benmumford.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

public class CandidateRowColumnGeneratorTests {
    
    private CandidateRowColumnGenerator target;
    
    @Before
    public void beforeEach() {
        target = new CandidateRowColumnGenerator();
    }
    
    @Test
    public void generateCandidates_with_zeroConstraints() {
        List<RowColumn> candidates = target.generateCandidates(10, new int[0]);
        
        Assert.assertEquals(1, candidates.size());
        RowColumn candidate = candidates.get(0);
        Assert.assertEquals(10, candidate.getLength());
        for (int i = 0; i < candidate.getLength(); ++i) {
            Assert.assertEquals(Cell.EMPTY, candidate.getValue(i));
        }
    }
    
    @Test
    public void generateCandidates_with_full() {
        List<RowColumn> candidates = target.generateCandidates(10, new int[] { 10 });
        
        Assert.assertEquals(1, candidates.size());
        RowColumn candidate = candidates.get(0);
        Assert.assertEquals(10, candidate.getLength());
        for (int i = 0; i < candidate.getLength(); ++i) {
            Assert.assertEquals(Cell.FULL, candidate.getValue(i));
        }
    }
    
    @Test
    public void generateCandidates_with_multipleAnswers_oneConstraint() {
        List<RowColumn> candidates = target.generateCandidates(10, new int[] { 8 });
        
        Assert.assertEquals(3, candidates.size());
    }
    
    @Test
    public void generateCandidates_with_multipleAnswers_multipleConstraint() {
        List<RowColumn> candidates = target.generateCandidates(10, new int[] { 5, 3 });
        
        Assert.assertEquals(3, candidates.size());
    }
}