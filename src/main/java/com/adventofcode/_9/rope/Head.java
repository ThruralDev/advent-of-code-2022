package com.adventofcode._9.rope;

import java.util.LinkedList;

public class Head {

    LinkedList<RopeMember> chainMembers = new LinkedList<>(){{
        add(new Tail(0, 0));
    }};
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
            chainMembers.listIterator(0)
                    .next()
                    .pullVertically(this.getX(), this.getY(), vector);
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);
            chainMembers.listIterator(0)
                    .next()
                    .pullHorizontally(this.getX(), this.getY(), vector);
        }
    }

    public int getNumberOfTailPositions() {

        return chainMembers.getLast().getNumberOfDifferentPositions();
    }
}