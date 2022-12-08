package com.adventofcode._7;

public class Util {

    public static String getCheckedCommandValue(String terminalLine) throws Exception{
        String commandValue = "";
        try {
            commandValue = terminalLine
                    .split(" ")[2];
        } catch (UnsupportedOperationException e) {
            throw new Exception(
                    "I don't support the feature for navigating home. Maybe at next version.");
        }
        if(commandValue.contains(".") && !commandValue.startsWith(".")) throw new Exception("Is not a directory!");
        return commandValue;
    }
}
