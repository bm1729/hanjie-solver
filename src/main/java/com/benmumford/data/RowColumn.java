package com.benmumford.data;

import java.util.Arrays;

public class RowColumn {
    
    private Cell[] data;
    
    public RowColumn(int length) {
        this.data = new Cell[length];
        Arrays.fill(this.data, Cell.NULL);
    }
    
    public RowColumn(RowColumn other) {
        this.data = new Cell[other.data.length];
        System.arraycopy(other.data, 0, this.data, 0, other.data.length);
    }
    
    public Cell getValue(int index) {
        return data[index];
    }
    
    public RowColumn applyValue(int index, Cell value) {
        if (value == null) {
            throw new IllegalArgumentException("Can't set null value on row/column");
        }
        
    	RowColumn toReturn = new RowColumn(this);
    	toReturn.data[index] = value;
    	
    	return toReturn;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(this.data);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RowColumn other = (RowColumn) obj;
		if (!Arrays.equals(this.data, other.data))
			return false;
		return true;
	}
}