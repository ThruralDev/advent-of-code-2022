package com.adventofcode._9.rope;

import java.util.HashSet;

public class RopeMember extends RopeHead {

    private final HashSet<String> positions = new HashSet<>() {{
        add("0,0");
    }};

    public RopeMember(int xPosition, int yPosition) {
        super(xPosition,yPosition);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    public void moveVertically(int vector) {

        setY(getY() + vector);
    }

    public void moveHorizontally(int vector) {

        setX(getX() + vector);
    }

    public void moveToSameAxis(int value, boolean isVertically) {

        if(isVertically){
            if(getX() != value){
                setX(value);
            }
        }else{
            if(getY() != value){
                setY(value);
            }
        }
    }


    public void pullVertically(int prevX, int prevY, int vector) {

        if (isTooFarAway(prevY, true)){
            moveVertically(vector);
            moveToSameAxis(prevX, true);
            registerPosition(getX() + "," + getY());
        }
    }

    public void pullHorizontally(int prevX, int prevY, int vector) {

        if (isTooFarAway(prevX, false)){
            moveHorizontally(vector);
            moveToSameAxis(prevY, false);
            registerPosition(getX() + "," + getY());
        }
    }

    public void registerPosition(String memberPosition) {
        if (memberPosition != null){
            System.out.printf("\nRope member moves to pos. %s", memberPosition);
            positions.add(memberPosition);
        }
    }

    private boolean isTooFarAway(int prevValue, boolean isVertically) {

        if(isVertically){
            return prevValue - getY() > 1 || getY() - prevValue > 1;
        }
        return prevValue - getX() > 1 || getX() - prevValue > 1;
    }

    public int getNumberOfDifferentTailPositions() {
        return positions.size();
    }
}
