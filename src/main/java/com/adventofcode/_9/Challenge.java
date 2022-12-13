package com.adventofcode._9;

import com.adventofcode._9.command.CommandProcessor;

import java.io.IOException;

public class Challenge {

    /**
     * @param args - path reference to input file from project root.
     *             - length from rope. When only head and tail, then the length is 2.
     * @throws IOException while extracting lines of input file into list.
     */
    public static void main(String[] args) throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor(args[0], args[1]);
        commandProcessor.run();
    }
}
