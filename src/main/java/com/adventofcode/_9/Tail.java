package com.adventofcode._9;

public class Tail {

    private int x;
    private int y;

    public Tail(int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String pullVertically(int prevX, int prevY, int vector) {

        if (prevY - getY() > 1 || getY() - prevY > 1){
            // First move tail along moving direction.
            setY(getY() + vector);
            // Shift to head's axis if not on same axis.
            if(getX() != prevX){
                setX(prevX);
            }
            return getX() + "," + getY();
        }
        return null;
    }

    public String pullHorizontally(int prevX, int prevY, int vector) {

        // Check if tail too far away.
        if (prevX - getX() > 1 || getX() - prevX > 1){
            // First move tail along moving direction.
            setX(getX() + vector);
            // Shift to head's axis if not on same axis.
            if(getY() != prevY){
                setY(prevY);
            }
            return getX() + "," + getY();
        }
        return null;
    }
}
