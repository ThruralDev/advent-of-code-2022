package com.adventofcode._9;

import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.Const;
import com.adventofcode.util.GeneralUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Challenge {

    public static void main(String[] args) throws IOException {

        String file = Const.RESOURCE_PATH + "input/09.txt";
        List<String> lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
        RopeHead rope = new RopeHead(0, 0);

        // Need Command direction mapper.
        HashMap<String, Integer> commandDictionary = new HashMap<>() {{
            put("U", 1);
            put("D", -1);
            put("R", 1);
            put("L", -1);
        }};

        lineList.forEach(line -> {
            Command command = new Command(
                    line.split(" ")[0],
                    Integer.parseInt(line.split(" ")[1]),
                    commandDictionary.get(line.split(" ")[0])
            );

            switch (command.id()) {

                case "U", "D" -> rope.moveVertically(command.value(), command.vector());
                case "R", "L" -> rope.moveHorizontally(command.value(), command.vector());
            }
        });

        System.out.printf("\nTail was on %s different positions", rope.getNumberOfDifferentTailPositions());
    }
}
