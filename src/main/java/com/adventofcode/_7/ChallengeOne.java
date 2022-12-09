package com.adventofcode._7;

import com.adventofcode.util.Const;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ChallengeOne {

    public static void main(String[] args) throws Exception {

        String terminalLine;
        String absolutePath = "/";
        String file = Const.RESOURCE_PATH + "input/07.txt";
        String commandValue;
        HashMap<String, Member> fileSizeMap = new HashMap<>();
        fileSizeMap.put("/", new Member(0, Type.DIRECTORY));

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            while ((terminalLine = br.readLine()) != null) {

                switch (terminalLine) {
                    case "$ cd .." -> {
                        absolutePath = absolutePath.replaceAll("\\/[a-zA-Z.]+/$", "/");
                        System.out.println(
                                "Moving one level up to " + absolutePath);
                    }
                    case "$ ls" -> {
                        // Sleep or do what you want.
                    }
                    default -> {

                        // When cd into subdirectory.
                        if (terminalLine.startsWith("$ cd")) {
                            commandValue = terminalLine.split(" ")[2];
                            if (commandValue.equals("/"))
                                absolutePath = "/";
                            else
                                absolutePath = absolutePath + commandValue + "/";
                            System.out.println("Moved to " + absolutePath);
                            if (fileSizeMap.get(absolutePath) == null)
                                fileSizeMap.put(absolutePath, new Member(0, Type.DIRECTORY));
                        }
                        // When scanning a directory.
                        else if (terminalLine.startsWith("dir")) {
                            commandValue = terminalLine.split(" ")[1];
                            System.out.println(
                                    String.format("Scanned directory %s in path %s", commandValue, absolutePath));
                            if (fileSizeMap.get(absolutePath + commandValue+ "/") == null) {
                                fileSizeMap.put(absolutePath + commandValue+ "/", new Member(0, Type.DIRECTORY));
                            }
                        }
                        // When scanning a file.
                        else {
                            commandValue = terminalLine.split(" ")[0];
                            String scannedFile = terminalLine.split(" ")[1];
                            System.out.println(
                                    String.format("Scanned file %s in path %s with size %s", scannedFile, absolutePath,
                                            commandValue));
                            int size = Integer.parseInt(commandValue);
                            if (fileSizeMap.get(absolutePath + scannedFile) == null) {
                                fileSizeMap.put(absolutePath + scannedFile, new Member(size, Type.FILE));

                                // Increasing size of parent folders.
                                String absoluteFeedPath = absolutePath;
                                int sizeToReplace;
                                while(!absoluteFeedPath.equals("/")){

                                    sizeToReplace = fileSizeMap.get(absoluteFeedPath).getSize();
                                    fileSizeMap.put(absoluteFeedPath, new Member(sizeToReplace + size, Type.DIRECTORY));
                                    absoluteFeedPath = absoluteFeedPath.replaceAll("\\/[a-zA-Z.]+/$", "/");
                                }
                                 sizeToReplace = fileSizeMap.get(absoluteFeedPath).getSize();
                                fileSizeMap.put(absoluteFeedPath, new Member(sizeToReplace + size, Type.DIRECTORY));
                            }
                        }
                    }
                }
            }
        }

        // Printing out result.
        fileSizeMap
                .remove("/");
        int result = fileSizeMap.values().stream()
                .filter(x -> x.getType().equals(Type.DIRECTORY) && x.getSize() <= 100000)
                .mapToInt(Member::getSize)
                .sum();
        System.out.println(result);
    }
}
