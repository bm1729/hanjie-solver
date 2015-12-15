package com.benmumford.algorithm;

import java.util.List;

import com.benmumford.data.RowColumn;

public interface ICommonRowColumnFinder {
    
    RowColumn findCommonRowColumn(List<RowColumn> rowColumns);
}