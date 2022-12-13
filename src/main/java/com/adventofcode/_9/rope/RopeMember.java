package com.adventofcode._9.rope;

import java.util.HashSet;

public interface RopeMember {

    void moveVertically(int vector);

    void moveHorizontally(int vector);

    void pullVertically(int prevX, int prevY, int vector);

    void pullHorizontally (int prevX, int prevY, int vector);

    void moveTowardsSameAxis(int value, boolean isVertically);

    void registerPosition(String memberPosition);

    int getNumberOfDifferentPositions();

    HashSet<String> getPositions();
}
