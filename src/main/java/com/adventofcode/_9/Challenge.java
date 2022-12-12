package com.adventofcode._9;

import com.adventofcode.util.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Challenge {

    public static void main(String[] args) throws IOException {

        String file = Const.RESOURCE_PATH + "input/09.txt";
        Head rope = new Head(0, 0);

        // Need Command direction mapper.
        HashMap<String, Integer> commandDictionary = new HashMap<>() {{
            put("U", 1);
            put("D", -1);
            put("R", 1);
            put("L", -1);
        }};

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            String terminalLine;
            while ((terminalLine = br.readLine()) != null) {

                Command command = new Command(
                        terminalLine.split(" ")[0],
                        Integer.parseInt(terminalLine.split(" ")[1]),
                        commandDictionary.get(terminalLine.split(" ")[0])
                );

                switch (command.id()) {

                    case "U" -> rope.moveUp(command.value(), command.vector());
                    case "D" -> rope.moveDown(command.value(), command.vector());
                    case "R" -> rope.moveRight(command.value(), command.vector());
                    case "L" -> rope.moveLeft(command.value(), command.vector());
                }
            }

            System.out.printf("\nTail was on %s different positions", rope.getNumberOfTailPoints());
        }
    }
}
