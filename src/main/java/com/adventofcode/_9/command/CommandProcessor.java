package com.adventofcode._9.command;

import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.GeneralUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CommandProcessor{

    List<String> lineList;
    RopeHead ropeHead;

    public CommandProcessor(String file, String ropeLength) throws IOException {

        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
        ropeHead = new RopeHead(Integer.parseInt(ropeLength),0, 0);
    }

    public void run() {
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
        System.out.printf("\nTail was on %s different positions", ropeHead.getNumberOfDifferentTailPositions());
    }

    public RopeHead getRopeHead() {
        return ropeHead;
    }
}
