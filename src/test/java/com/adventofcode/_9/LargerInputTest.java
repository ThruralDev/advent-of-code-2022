package com.adventofcode._9;

import com.adventofcode._9.command.CommandProcessor;
import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LargerInputTest {

    RopeHead ropeHead;

    public LargerInputTest() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor(Const.RESOURCE_TEST_PATH + "09/larger.txt", "10");
        commandProcessor.run();
        this.ropeHead = commandProcessor.getRopeHead();
    }

    @Test
    @DisplayName("Check if 1 is result with 10 knots.")
    public void CheckIf1IsResultOfShortInput() {

        Assertions.assertEquals(ropeHead.getNumberOfDifferentTailPositions(), 1);
    }

    @Test
    @DisplayName("Check if 6 is not result with 10 knots.")
    public void CheckIf6IsNotResultOfShortInput() {

        Assertions.assertNotEquals(ropeHead.getNumberOfDifferentTailPositions(), 6);
    }
}
