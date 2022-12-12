package com.adventofcode._9;

import java.util.HashSet;

public class Rope {

    private final HashSet<String> headPositions = new HashSet<>() {{
        add("0,0");
    }};
    private final HashSet<String> tailPositions = new HashSet<>() {{
        add("0,0");
    }};
    Head head = new Head(0, 0);
    Tail tail = new Tail(0, 0);

    public Rope() {

    }

    public void moveUp(int commandValue, int vector) {
        for (int i = 0; i < commandValue; i++) {
            // Move head.
            head.setY(head.getY() + vector);
            registerHeadPosition();

            // Check if tail too far away.
            if (head.getY() - tail.getY() > 1){
                // First move tail along moving direction.
                tail.setY(tail.getY() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getX() != head.getX()){
                    tail.setX(head.getX());
                }
                registerTailPosition();
            }
        }
    }

    public void moveDown(int commandValue, int vector) {
        for (int i = 0; i < commandValue; i++) {
            // Move head.
            head.setY(head.getY() + vector);
            registerHeadPosition();

            // Check if tail too far away.
            if (tail.getY() - head.getY() > 1){
                // First move tail along moving direction.
                tail.setY(tail.getY() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getX() != head.getX()){
                    tail.setX(head.getX());
                }
                registerTailPosition();
            }
        }
    }

    public void moveRight(int commandValue, int vector) {

        for (int i = 0; i < commandValue; i++) {
            // Move head.
            head.setX(head.getX() + vector);
            registerHeadPosition();

            // Check if tail too far away.
            if (head.getX() - tail.getX() > 1){
                // First move tail along moving direction.
                tail.setX(tail.getX() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getY() != head.getY()){
                    tail.setY(head.getY());
                }
                registerTailPosition();
            }
        }
    }

    public void moveLeft(int commandValue, int vector) {
        for (int i = 0; i < commandValue; i++) {
            // Move head.
            head.setX(head.getX() + vector);
            registerHeadPosition();

            // Check if tail too far away.
            if (tail.getX() - head.getX() > 1){
                // First move tail along moving direction.
                tail.setX(tail.getX() + vector);
                // Shift to head's axis if not on same axis.
                if(tail.getY() != head.getY()){
                    tail.setY(head.getY());
                }
                registerTailPosition();
            }
        }
    }

    private void registerHeadPosition(){

        headPositions.add(head.getX() + "," + head.getY());
    }

    private void registerTailPosition(){

        tailPositions.add(tail.getX() + "," + tail.getY());
    }

    public int getNumberOfTailPoints(){

        return tailPositions.size();
    }
}
