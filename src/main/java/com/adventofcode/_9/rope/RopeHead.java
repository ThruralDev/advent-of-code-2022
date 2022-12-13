package com.adventofcode._9.rope;

import java.util.LinkedList;
import java.util.ListIterator;

public class RopeHead {

    private int x;
    private int y;

    LinkedList<RopeMember> ropeMembers;

    public RopeHead(int ropeLength, int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
        ropeMembers = new LinkedList<>() {{
            for(int i = 0; i < ropeLength;i++) add(new RopeMember(0,0));
        }};
        System.out.println("All rope members start on pos. 0,0");
    }

    public RopeHead(int x, int y) {
        this.x = x;
        this.y = y;
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
            System.out.printf("\nHead moves to pos. %s,%s", getX(), getY());
            ListIterator<RopeMember> ropeIterator = ropeMembers.listIterator(0);
            for (int j = 0; j < ropeMembers.size(); j++){
                ropeIterator
                        .next()
                        .pullVertically(this.getX(), this.getY(), vector);
            }
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);
            System.out.printf("\nHead moves to pos. %s,%s", getX(), getY());
            ListIterator<RopeMember> ropeIterator = ropeMembers.listIterator(0);
            for (int j = 0; j < ropeMembers.size(); j++){
                ropeIterator
                        .next()
                        .pullHorizontally(this.getX(), this.getY(), vector);
            }
        }
    }

    public int getNumberOfDifferentTailPositions() {

        return ropeMembers.getLast().getNumberOfDifferentTailPositions();
    }
}
