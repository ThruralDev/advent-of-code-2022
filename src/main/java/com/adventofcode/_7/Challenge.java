package com.adventofcode._7;

import com.adventofcode.util.Const;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Challenge {

    public static void main(String[] args) throws Exception {

        String terminalLine;
        String absolutePath = "/";
        String file = Const.RESOURCE_PATH + "input/07.txt";
        String commandValue;
        int totalMemory = 70000000;
        int requiredUnusedMemory = 30000000;
        int maxUsedMemory = totalMemory - requiredUnusedMemory;
        boolean isChallengeOne = false;
        HashMap<String, Member> fileSizeMap = new HashMap<>();
        fileSizeMap.put("/", new Member(0, Type.DIRECTORY));

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            while ((terminalLine = br.readLine()) != null) {

                switch (terminalLine) {
                    case "$ cd .." -> {

                        // Trimming absolute path by one level.
                        absolutePath = absolutePath.replaceAll("\\/[a-zA-Z.]+/$", "/");
                        System.out.printf(
                                "Moving one level up to %s", absolutePath);
                    }
                    case "$ ls" -> {
                        // Sleep or do what you want.
                    }
                    default -> {

                        // When cd into subdirectory.
                        if (terminalLine.startsWith("$ cd")) {
                            commandValue = terminalLine.split(" ")[2];

                            // Move to root.
                            if (commandValue.equals("/"))
                                absolutePath = "/";
                            else
                                absolutePath = absolutePath + commandValue + "/";

                            System.out.printf("Moved to %s", absolutePath);

                            // Register directory.
                            if (fileSizeMap.get(absolutePath) == null)
                                fileSizeMap.put(absolutePath, new Member(0, Type.DIRECTORY));
                        }
                        // When scanning a directory.
                        else if (terminalLine.startsWith("dir")) {
                            commandValue = terminalLine.split(" ")[1];
                            System.out.printf("Scanned directory %s in path %s%n", commandValue, absolutePath);
                            if (fileSizeMap.get(absolutePath + commandValue + "/") == null) {
                                fileSizeMap.put(absolutePath + commandValue + "/", new Member(0, Type.DIRECTORY));
                            }
                        }
                        // When scanning a file.
                        else {
                            commandValue = terminalLine.split(" ")[0];
                            String scannedFile = terminalLine.split(" ")[1];
                            System.out.printf("Scanned file %s with size %s%n", scannedFile, commandValue);

                            // Register file.
                            int fileSize = Integer.parseInt(commandValue);
                            if (fileSizeMap.get(absolutePath + scannedFile) == null) {
                                fileSizeMap.put(absolutePath + scannedFile, new Member(fileSize, Type.FILE));

                                // Increasing size of parent folders.
                                String absoluteFeedPath = absolutePath;
                                int sizeToReplace;
                                while (!absoluteFeedPath.equals("/")) {

                                    sizeToReplace = fileSizeMap.get(absoluteFeedPath).getSize();
                                    fileSizeMap.put(absoluteFeedPath,
                                            new Member(sizeToReplace + fileSize, Type.DIRECTORY));
                                    absoluteFeedPath = absoluteFeedPath.replaceAll("\\/[a-zA-Z.]+/$", "/");
                                }

                                // Same for root directory.
                                sizeToReplace = fileSizeMap.get(absoluteFeedPath).getSize();
                                fileSizeMap.put(absoluteFeedPath, new Member(sizeToReplace + fileSize, Type.DIRECTORY));
                            }
                        }
                    }
                }
            }
        }

        if (isChallengeOne)
            fileSizeMap.remove("/");

        // Printing out result for challenge one.
        int resultOne = fileSizeMap.values().stream()
                .filter(x -> x.getType().equals(Type.DIRECTORY) && x.getSize() <= 100000)
                .mapToInt(Member::getSize)
                .sum();
        System.out.printf("Sum of all subdirectories with at most 100000 is %s", resultOne);

        // Printing out result for challenge one.
        int usedMemory = fileSizeMap.get("/").getSize();
        int notUsedMemory = totalMemory - usedMemory;
        int memoryToRemove = Math.abs(notUsedMemory - requiredUnusedMemory);
        System.out.printf("\nTotal memory: %s and used: %s\nNeed to free at least %s of memory for update.",
                totalMemory, usedMemory, memoryToRemove);

        // Find directory with at least memory to remove.
        Optional<Map.Entry<String, Member>> deletionCandidate = fileSizeMap.entrySet().stream()
                .sorted(Comparator.comparing(x -> x.getValue().getSize()))
                .filter(x -> x.getValue().getType().equals(Type.DIRECTORY) && x.getValue().getSize() >= memoryToRemove)
                .findFirst();
        System.out.printf("\nYou have to delete directory %s with size of %s",
                deletionCandidate.get().getKey(),
                deletionCandidate.get().getValue().getSize());
    }
}
