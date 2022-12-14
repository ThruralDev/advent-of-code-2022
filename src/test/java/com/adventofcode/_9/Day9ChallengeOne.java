package com.adventofcode._9;

import com.adventofcode._9.rope.RopeHead;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Day9ChallengeOne {

    RopeHead rope = new RopeHead(0, 0){{
        moveHorizontally(4, 1);
        moveVertically(4, 1);
        moveHorizontally(3, -1);
        moveVertically(1, -1);
        moveHorizontally(4, 1);
        moveVertically(1, -1);
        moveHorizontally(5, -1);
        moveHorizontally(2, 1);
    }};

    private final HashSet<String> ExpectedPositions = new HashSet<>() {{
        add("0,0");
        add("1,0");
        add("2,0");
        add("1,2");
        add("3,1");
        add("1,3");
        add("2,2");
        add("1,4");
        add("2,3");
        add("3,2");
        add("4,2");
        add("3,3");
        add("2,4");
    }};

    @Test
    @DisplayName("Result for challenge one with test input if 13 positions.")
    public void testInputForChallengeOneToGetTotalTailPositions() {

        Assert.assertEquals(rope.getNumberOfDifferentTailPositions(), 13);
    }

    @DisplayName("Check if tail positions matches as set with expected one.")
    @Test
    public void testInputForChallengeOneToMatchWithExpectedSetOfPositions(){

        Assert.assertEquals(ExpectedPositions, rope.getNumberOfDifferentTailPositions());
    }
}
