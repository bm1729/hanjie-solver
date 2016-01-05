package com.benmumford.algorithm;

import com.benmumford.data.Cell;
import com.benmumford.data.RowColumn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CandidateRowColumnTrimmer implements ICandidateRowColumnTrimmer {
    
    public List<RowColumn> trimCandidates(List<RowColumn> candidates, RowColumn actual) {
        List<RowColumn> toReturn = new ArrayList<RowColumn>();
        for (RowColumn candidate : candidates) {
            boolean acceptCandidate = true;
            for (int i = 0; i < actual.getLength(); ++i) {
                if (actual.getValue(i) != Cell.NULL && actual.getValue(i) != candidate.getValue(i)) {
                    acceptCandidate = false;
                    break;
                }
            }
            
            if (acceptCandidate) {
                toReturn.add(candidate);
            }
        }
        
        return toReturn;
    }
} 