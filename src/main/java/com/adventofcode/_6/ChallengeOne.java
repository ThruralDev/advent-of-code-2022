package com.adventofcode._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChallengeOne {

    public static void main(String[] args) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/resources/input/06.txt"))) {

            String line = br.readLine();
            // TODO: 06.12.22 Iterate through line and append the current index to a queue of size 4 with fifo-principal.

            // TODO: 06.12.22 Check if queue has different Strings inside. If so the result is the current index + 1.

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}
