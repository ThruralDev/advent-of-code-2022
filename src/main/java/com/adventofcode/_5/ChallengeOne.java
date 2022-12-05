package com.adventofcode._5;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ChallengeOne {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/05-2.txt"));
        Result result = new Result();

        // Get stacks of crates as string-map.
        HashMap<Integer, String> stackMap = DayFiveUtil.initializeStacks("05-1.txt", 9);
        HashMap<String, Integer> instructionMap = DayFiveUtil.initializeInstructionMap();
        String nextCrates;
        String newStack;

        // Extract information of commands.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Get instructions into map.
            List<Integer> instructions = Arrays
                    .stream(line
                            .replaceAll("\\D", " ")
                            .replaceAll("^ +", "")
                            .split(" +"))
                    .map(Integer::valueOf).toList();
            instructionMap.put("origin", instructions.get(1));
            instructionMap.put("destination", instructions.get(2));
            instructionMap.put("quantity", instructions.get(0));

            // Process information in instruction-map on stack-map.
            try {
                nextCrates = stackMap
                        .get(instructionMap.get("origin"))
                        .substring(
                                stackMap.get(instructionMap.get("origin")).length() - instructionMap.get("quantity"));

                // Remove the creates from origin.
                newStack = stackMap.get(instructionMap.get("origin"))
                        .substring(0, stackMap.get(instructionMap.get("origin")).length() - nextCrates.length());
                stackMap.put(instructionMap.get("origin"), newStack);

                // revert nexCreates.
                nextCrates = new StringBuilder(nextCrates).reverse().toString();

                // Append nextCrates to destination.
                stackMap.put(instructionMap.get("destination"),
                        stackMap.get(instructionMap.get("destination")) + nextCrates);

            } catch (StringIndexOutOfBoundsException e) {
                throw new RuntimeException("There are no crates at the origin!", e);
            }
        }
        scanner.close();

        stackMap.values().forEach(x -> result.addToSequence(x.length() > 1 ? x.substring(x.length() - 1) : x));
        System.out.println("On the top of stacks are following crates: " + result.getSequence());
    }
}
