package com.adventofcode._9.rope;

import java.util.LinkedList;
import java.util.ListIterator;

public class Head {

    LinkedList<RopeMember> ropeMembers;
    private int x;
    private int y;

    public Head(int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
        ropeMembers = new LinkedList<>() {{
            add(new RopeMemberLinkImpl(0, 0));
            add(new RopeMemberTailImpl(0, 0));
        }};
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
        int futureY;
        for (int i = 0; i < commandValue; i++) {
            setY(getY() + vector);
            System.out.println();
            System.out.println("Head  pos. : " + getX() + "," + getY());
            ListIterator<RopeMember> ropeIterator = ropeMembers.listIterator(0);
            for (int j = 0; j < ropeMembers.size(); j++){

                // handle idle members.
                futureY = this.getY();
                futureY -= j;
                if(futureY < 0) futureY = 0;

                ropeIterator
                        .next()
                        .pullVertically(this.getX(), futureY, vector);
            }
        }
    }

    public void moveHorizontally(int commandValue, int vector) {

        int futureX;
        for (int i = 0; i < commandValue; i++) {
            setX(getX() + vector);
            System.out.println();
            System.out.println("Head  pos. : " + getX() + "," + getY());
            ListIterator<RopeMember> ropeIterator = ropeMembers.listIterator(0);
            for (int j = 0; j < ropeMembers.size(); j++){

                // handle idle members.
                futureX = this.getX();
                futureX -= j;
                if(futureX < 0) futureX = 0;

                ropeIterator
                        .next()
                        .pullHorizontally(futureX, this.getY(), vector);
            }
        }
    }

    public int getNumberOfDifferentTailPositions() {

        return ropeMembers.getLast().getNumberOfDifferentPositions();
    }
}
