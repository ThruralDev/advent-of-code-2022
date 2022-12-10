package com.adventofcode._8;

public class Tree {

    private int height;
    private int row;
    private int col;
    private boolean isVisible;

    public Tree(int height, int row, int col) {

        this.height = height;
        this.row = row;
        this.col = col;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    public int getRow() {

        return row;
    }

    public void setRow(int row) {

        this.row = row;
    }

    public int getCol() {

        return col;
    }

    public void setCol(int col) {

        this.col = col;
    }

    public boolean isVisible() {

        return isVisible;
    }

    public void setVisible(boolean visible) {

        isVisible = visible;
    }

    @Override
    public String toString() {

        return "Tree{" +
                "height=" + height +
                ", row=" + row +
                ", col=" + col +
                ", isVisible=" + isVisible +
                '}';
    }
}
