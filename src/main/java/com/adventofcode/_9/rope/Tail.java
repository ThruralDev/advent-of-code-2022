package com.adventofcode._9.rope;

import java.util.HashSet;

public class Tail extends Link implements RopeMember {

    private final HashSet<String> positions = new HashSet<>() {{
        add("0,0");
    }};

    public Tail(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void pullVertically(int prevX, int prevY, int vector) {

        if (isTooFarAway(prevY, true)){
            // First move tail along moving direction.
            setY(getY() + vector);
            // Shift to head's axis if not on same axis.
            if(getX() != prevX){
                setX(prevX);
            }
            registerTailPosition(getX() + "," + getY());
        }
    }

    public void pullHorizontally(int prevX, int prevY, int vector) {

        // Check if tail too far away.
        if (isTooFarAway(prevX, false)){
            // First move tail along moving direction.
            setX(getX() + vector);
            // Shift to head's axis if not on same axis.
            if(getY() != prevY){
                setY(prevY);
            }
            registerTailPosition(getX() + "," + getY());
        }
    }

    private boolean isTooFarAway(int prevValue, boolean isVertically) {

        if(isVertically){
            return prevValue - getY() > 1 || getY() - prevValue > 1;
        }
        return prevValue - getX() > 1 || getX() - prevValue > 1;
    }


    private void registerTailPosition(String memberPosition){

        if (memberPosition != null){
            positions.add(memberPosition);
        }
    }

    public int getNumberOfDifferentPositions(){

        return positions.size();
    }
}
