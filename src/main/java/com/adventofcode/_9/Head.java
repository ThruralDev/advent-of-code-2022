package com.adventofcode._9;

import java.util.HashSet;

public class Head {
    
    private final HashSet<String> tailPositions = new HashSet<>() {{
        add("0,0");
    }};
    Link tail = new Link(0, 0);
    private int x;
    private int y;

    public Head(int xPosition, int yPosition) {
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

    public void moveVertically(int commandValue, int vector) {
        for (int i = 0; i < commandValue; i++) {
            setY(getY() + vector);
            registerTailPosition(tail.pullVertically(this.getX(), this.getY(), vector));
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);
            registerTailPosition(tail.pullHorizontally(this.getX(), this.getY(), vector));
        }
    }

    private void registerTailPosition(String memberPosition){
        if (memberPosition != null){
            tailPositions.add(tail.getX() + "," + tail.getY());
        }
    }

    public int getNumberOfTailPoints(){

        return tailPositions.size();
    }
}
