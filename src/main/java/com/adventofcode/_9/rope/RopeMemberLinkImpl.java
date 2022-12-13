package com.adventofcode._9.rope;

import java.util.HashSet;

public class RopeMemberLinkImpl implements RopeMember {

    private int x;
    private int y;
    private final HashSet<String> positions = new HashSet<>() {{
        add("0,0");
    }};

    public RopeMemberLinkImpl(int xPosition, int yPosition) {
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

    public void moveVertically(int vector) {

        setY(getY() + vector);
    }

    public void moveHorizontally(int vector) {

        setX(getX() + vector);
    }

    // TODO: 13.12.22 Make this happen to all members at each step. 
    public void moveTowardsSameAxis(int value, boolean isVertically) {

        int offsetDirectionX = getX() - value;
        int offsetDirectionY = getY() - value;
        int offsetX;
        int offsetY;

        if(offsetDirectionX > 0) offsetX = -1; else offsetX = 1;
        if(offsetDirectionY > 0) offsetY = -1; else offsetY = 1;

        if(isVertically){
            if(getX() != value){
                setX(getX() + offsetX);
                System.out.println("Move towards.");
            }
        }else{
            if(getY() != value){
                setY(getY() + offsetY);
                System.out.println("Move towards.");
            }
        }
    }

    public void pullVertically(int prevX, int prevY, int vector) {

        if (isTooFarAway(prevY, true)){
            moveVertically(vector);
            moveTowardsSameAxis(prevX, true);
            registerPosition(getX() + "," + getY());
        }
    }

    public void pullHorizontally(int prevX, int prevY, int vector) {

        if (isTooFarAway(prevX, false)){
            moveHorizontally(vector);
            moveTowardsSameAxis(prevY, false);
            registerPosition(getX() + "," + getY());
        }
    }

    public void registerPosition(String memberPosition) {

        System.out.println("Link pos.: " + memberPosition);
        if (memberPosition != null){
            positions.add(memberPosition);
        }
    }

    private boolean isTooFarAway(int prevValue, boolean isVertically) {

        if(isVertically){
            return prevValue - getY() > 1 || getY() - prevValue > 1;
        }
        return prevValue - getX() > 1 || getX() - prevValue > 1;
    }

    public int getNumberOfDifferentPositions(){

        return positions.size();
    }

    public HashSet<String> getPositions() {

        return positions;
    }
}
