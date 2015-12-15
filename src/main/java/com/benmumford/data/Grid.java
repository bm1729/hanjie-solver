package com.benmumford.data;

public class Grid {
    
    private RowColumn[] rows;
    private RowColumn[] columns;
    
    public Grid(int numberOfRows, int numberOfColumns) {
        if (numberOfColumns <= 0 || numberOfRows <= 0) {
            throw new IllegalArgumentException("Must have positive number of rows and columns");
        }
        
        this.rows = new RowColumn[numberOfRows];
        for (int row = 0; row < numberOfRows; ++row) {
            this.rows[row] = new RowColumn(numberOfColumns);
        }
        
        this.columns = new RowColumn[numberOfColumns];
        for (int col = 0; col < numberOfColumns; ++col) {
            this.columns[col] = new RowColumn(numberOfRows);
        }
    }
    
    private Grid() {}
    
    public RowColumn getRow(int index) {
        return this.rows[index];
    }
    
    public RowColumn getColumn(int index) {
        return this.columns[index];
    }
    
    public int getNumberOfRows() {
        return this.rows.length;
    }
    
    public int getNumberOfColumns() {
        return this.columns.length;
    }
    
    public Grid applyRow(int index, RowColumn row) {
        
        if (row.getLength() != this.rows[0].getLength()) {
            throw new IllegalArgumentException("All rows must be the same length");
        }
        
        Grid toReturn = new Grid();
        toReturn.rows = new RowColumn[getNumberOfRows()];
        toReturn.columns = new RowColumn[getNumberOfColumns()];
        
        for (int i = 0; i < getNumberOfRows(); ++i) {
            if (i == index) {
                toReturn.rows[i] = row;
            } else {
                toReturn.rows[i] = this.rows[i];
            }
        }
        
        for (int i = 0; i < getNumberOfColumns(); ++i) {
            toReturn.columns[i] = this.columns[i].applyValue(index, row.getValue(i));
        }
        
        return toReturn;
    }
    
    public Grid applyColumn(int index, RowColumn column) {
        
        if (column.getLength() != this.columns[0].getLength()) {
            throw new IllegalArgumentException("All columns must be the same length");
        }
        
        Grid toReturn = new Grid();
        toReturn.rows = new RowColumn[getNumberOfRows()];
        toReturn.columns = new RowColumn[getNumberOfColumns()];
        
        for (int i = 0; i < getNumberOfColumns(); ++i) {
            if (i == index) {
                toReturn.columns[i] = column;
            } else {
                toReturn.columns[i] = this.columns[i];
            }
        }
        
        for (int i = 0; i < getNumberOfRows(); ++i) {
            toReturn.rows[i] = this.rows[i].applyValue(index, column.getValue(i));
        }
        
        return toReturn;
    }
}