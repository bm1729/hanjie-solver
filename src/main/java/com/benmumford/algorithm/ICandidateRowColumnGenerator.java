package com.benmumford.algorithm;

import com.benmumford.data.RowColumn;

import java.util.List;

public interface ICandidateRowColumnGenerator {
    
    List<RowColumn> generateCandidates(int length, int... constraints);
}