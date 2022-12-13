package com.adventofcode._9;

import com.adventofcode._9.command.CommandProcessor;
import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ShortInputTest {

    RopeHead ropeHead;

    public ShortInputTest() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor(Const.RESOURCE_TEST_PATH + "09/smaller.txt", "2");
        commandProcessor.run();
        this.ropeHead = commandProcessor.getRopeHead();
    }

    @Test
    @DisplayName("Check if 13 is result with 2 knots.")
    public void CheckIf13IsResultWithTwoKnots() {

        Assertions.assertEquals(ropeHead.getNumberOfDifferentTailPositions(), 13);
    }

    @Test
    @DisplayName("Check if 10 is not result with 2 knots.")
    public void CheckIf10IsNotResultWithTwoKnots() {

        Assertions.assertNotEquals(ropeHead.getNumberOfDifferentTailPositions(), 10);
    }
}
