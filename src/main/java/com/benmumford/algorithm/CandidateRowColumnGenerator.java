package com.benmumford.algorithm;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

@Component
public class CandidateRowColumnGenerator {
    
    public List<RowColumn> generateCandidates(int length, int[] constraints) {
        LinkedList<RowColumn> candidates = new LinkedList<>();
        generateCandidates(candidates, createEmptyRowColumn(length), 0, length, constraints);
        
        return candidates;
    }
    
    private RowColumn createEmptyRowColumn(int length) {
        RowColumn source = new RowColumn(length);
        for (int i = 0; i < length; ++i) {
            source = source.applyValue(i, Cell.EMPTY);
        }
        
        return source;
    }
    
    private void generateCandidates(List<RowColumn> candidates, RowColumn source, int startIndex, int length, int[] constraints) {
        if (constraints.length == 0) {
            candidates.add(source);
            return;
        }
        
        int nextConstraint = constraints[0];
        
        if (length - startIndex < nextConstraint) {
            return;
        } else {
            int[] otherConstraints = removeFirstElement(constraints);
            generateCandidates(candidates, applyConstraint(startIndex, nextConstraint, source), startIndex + nextConstraint + 1, length, otherConstraints);
            generateCandidates(candidates, source, startIndex + 1, length, constraints);
        }
    }
    
    private RowColumn applyConstraint(int startIndex, int constraint, RowColumn source) {
        RowColumn toReturn = source;
        for (int i = startIndex; i < startIndex + constraint; ++i) {
            toReturn = toReturn.applyValue(i, Cell.FULL);
        }
        
        return toReturn;
    }
    
    private int sumOfConstraints(int[] constraints) {
        if (constraints.length == 0) {
            return 0;
        } else {
            int toReturn = 0;
            for (int constraint : constraints) {
                toReturn += constraint;
            }
            toReturn += constraints.length - 1;
            
            return toReturn;
        }
    }
    
    private int[] removeFirstElement(int[] constraints) {
        return Arrays.copyOfRange(constraints, 1, constraints.length);
    }
}