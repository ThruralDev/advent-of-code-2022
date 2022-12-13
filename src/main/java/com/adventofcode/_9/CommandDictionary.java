package com.adventofcode._9;

import java.util.HashMap;

public class CommandDictionary {

    static HashMap<String, Integer> commandDictionary = new HashMap<>() {{
        put("U", 1);
        put("D", -1);
        put("R", 1);
        put("L", -1);
    }};

    public static int getCommandVector (String command) {

        return commandDictionary.get(command);
    }
}
