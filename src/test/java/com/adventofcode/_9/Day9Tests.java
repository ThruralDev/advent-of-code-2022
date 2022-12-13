package com.adventofcode._9;

import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.Const;
import com.adventofcode.util.GeneralUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day9Tests {

    String file;
    List<String> lineList;
    RopeHead ropeHead;

    public Day9Tests() throws IOException {
        file = Const.RESOURCE_TEST_PATH + "09.txt";
        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
        ropeHead = new RopeHead(0,0);
        processCommands();
    }

    public void processCommands (){
        lineList.forEach(line -> {

            String commandDirection = line.split(" ")[0];
            int commandValue = Integer.parseInt(line.split(" ")[1]);

            Command command = new Command(
                    commandDirection,
                    commandValue,
                    CommandDictionary.getCommandVector(commandDirection)
            );

            switch (command.direction()) {

                case "U", "D" -> ropeHead.moveVertically(command.value(), command.vector());
                case "R", "L" -> ropeHead.moveHorizontally(command.value(), command.vector());
            }
        });
    }

    @Test
    @DisplayName("Check if 13 is result of short test-input.")
    public void CheckIf13IsResultOfShortInput() {

        Assertions.assertEquals(ropeHead.getNumberOfDifferentTailPositions(), 13);
    }

    @Test
    @DisplayName("Check if 10 is result of short test-input.")
    public void CheckIf10IsNotResultOfShortInput() {

        Assertions.assertNotEquals(ropeHead.getNumberOfDifferentTailPositions(), 10);
    }
}
