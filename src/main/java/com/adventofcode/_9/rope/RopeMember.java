package com.adventofcode._9.rope;

public interface RopeMember {

    void pullVertically(int prevX, int prevY, int vector);

    void pullHorizontally (int prevX, int prevY, int vector);

    void registerPosition(String memberPosition);

    int getNumberOfDifferentPositions();
}
