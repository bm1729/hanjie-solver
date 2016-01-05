package com.benmumford.algorithm;

import com.benmumford.data.RowColumn;

import java.util.List;

public interface ICandidateRowColumnTrimmer {
    
    List<RowColumn> trimCandidates(List<RowColumn> candidates, RowColumn actual);
} 