package com.adventofcode._9.rope;

import java.util.LinkedList;

public class Head {

    LinkedList<RopeMember> ropeMembers = new LinkedList<>(){{
        add(new Link(0, 0));
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
            for(int j = 0; j < ropeMembers.size(); j++){
                ropeMembers.listIterator(j)
                        .next()
                        .pullVertically(this.getX(), this.getY(), vector);
            }
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);
            for(int j = 0; j < ropeMembers.size(); j++){
                ropeMembers.listIterator(0)
                        .next()
                        .pullHorizontally(this.getX(), this.getY(), vector);
            }
        }
    }

    public int getNumberOfTailPositions() {

        return ropeMembers.get(0).getNumberOfDifferentPositions();
    }
}
