package com.adventofcode._9;

import java.util.HashSet;

public class Head {
    
    private final HashSet<String> tailPositions = new HashSet<>() {{
        add("0,0");
    }};
    Tail tail = new Tail(0, 0);
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

            // Check if tail too far away.
            if (getY() - tail.getY() > 1 || tail.getY() - getY() > 1){
                // First move tail along moving direction.
                tail.setY(tail.getY() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getX() != getX()){
                    tail.setX(getX());
                }
                registerTailPosition();
            }
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);

            // Check if tail too far away.
            if (getX() - tail.getX() > 1 || tail.getX() - getX() > 1){
                // First move tail along moving direction.
                tail.setX(tail.getX() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getY() != getY()){
                    tail.setY(getY());
                }
                registerTailPosition();
            }
        }
    }

    private void registerTailPosition(){

        tailPositions.add(tail.getX() + "," + tail.getY());
    }

    public int getNumberOfTailPoints(){

        return tailPositions.size();
    }
}
