package com.adventofcode._7;

import com.adventofcode._7.filesystem.FileSystem;
import com.adventofcode._7.filesystem.Member;
import com.adventofcode._7.filesystem.Path;
import com.adventofcode.util.Const;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

import static com.adventofcode._7.Util.getCheckedCommandValue;

public class ChallengeOne {

    public static void main(String[] args) throws Exception {

        String terminalLine;
        String absolutePath;
        String file = Const.RESOURCE_PATH + "input/07.txt";
        String commandValue;
        HashMap<String, Member> fileSizeMap = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            while ((terminalLine = br.readLine()) != null) {

                switch (terminalLine) {
                    case "$ cd .." -> {

                    }
                    case "ls" -> {

                    }
                    default -> {

                    }
                }

                if (!fileSystem.getIsBusy()) {

                    commandOption = terminalLine
                            .split(" ")[1];

                    // Route execution of command based on Option.
                    switch (commandOption) {
                        case "ls" -> {
                            fileSystem.setIsBusy(true);
                        }
                        case "cd" -> {

                            // Filter provided value.
                            commandValue = getCheckedCommandValue(terminalLine);

                            // Updating path based on value.
                            switch (commandValue) {
                                case "." -> {
                                    path.sleepOnTree();
                                }
                                case ".." -> {
                                    path.moveOneToRoot();
                                }
                                default -> {

                                    // Insert to map if not present yet.
                                    if (commandValue.startsWith("/")) {
                                        path.moveToAbsolute(commandValue);
                                        fileSystem.registerDirectoryToFileSystem(path.getPath());
                                    } else {
                                        path.chainPath(commandValue);
                                        fileSystem.registerDirectoryToFileSystem(path.getPath());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    br.mark(100);
                    if(terminalLine.startsWith("$")) {
                        br.reset();
                        fileSystem.setIsBusy(false);
                        continue;
                    }
                    String[] listOutputParts = terminalLine.split(" ");
                    boolean isDirectory = Objects.equals(listOutputParts[0], "dir");

                    // Appending member attributes to hashmap.
                    if (isDirectory) {
                        fileSystem.registerDirectoryToFileSystem(path.getPath() + listOutputParts[1]);
                    }
                    else {
                        fileSystem.registerFileToFileSystem(path.getPath() + listOutputParts[1], listOutputParts[0]);
                        System.out.println();
                    }
                }
            }
        }
        fileSystem.getFileSizeMember("/a/e/");
    }
}
