package com.adventofcode._9.rope;

import java.util.HashSet;

public class RopeMemberTailImpl implements RopeMember {

    private int x;
    private int y;
    private final HashSet<String> positions = new HashSet<>() {{
        add("0,0");
    }};

    public RopeMemberTailImpl(int x, int y) {
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

    public void moveVertically(int vector) {

        setY(getY() + vector);
    }

    public void moveHorizontally(int vector) {

        setX(getX() + vector);
    }

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
            }
        }else{
            if(getY() != value){
                setY(getY() + offsetY);
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

    private boolean isTooFarAway(int prevValue, boolean isVertically) {

        if(isVertically){
            return prevValue - getY() > 1 || getY() - prevValue > 1;
        }
        return prevValue - getX() > 1 || getX() - prevValue > 1;
    }


    public void registerPosition(String memberPosition){

        System.out.println("Tail pos.: " + memberPosition);
        if (memberPosition != null){
            positions.add(memberPosition);
            positions.forEach(System.out::println);
        }
    }

    public int getNumberOfDifferentPositions(){

        return positions.size();
    }

    public HashSet<String> getPositions() {
        return positions;
    }
}
