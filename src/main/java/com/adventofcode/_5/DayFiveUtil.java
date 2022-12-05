package com.adventofcode._5;

import com.adventofcode.util.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DayFiveUtil {

    public static HashMap<String, Integer> initializeInstructionMap() {

        HashMap<String, Integer> hashMap = new HashMap<>(3);
        hashMap.put("origin", null);
        hashMap.put("destination", null);
        hashMap.put("quantity", null);
        return hashMap;
    }


    public static HashMap<Integer, String> initializeStacks(String file, int nStacks) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/" + file));
        String line;
        String[] levelCrates = new String[nStacks];

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i < nStacks + 1; i++) {
            hashMap.put(i, "");
        }

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            for(int i = 1,j = 0;j < nStacks;i+=4, j++) {
                try{
                    if(line.charAt(i) != ' '){
                        levelCrates[j] = String.valueOf(line.charAt(i));
                    }else{
                        levelCrates[j] = "";
                    }
                }catch (Exception e){
                    levelCrates[j] = "";
                }
            }

            // Map current stack-level to each appropriate index/key of map.
            for (int i = 0; i < nStacks; i++) {
                hashMap.put(i + 1, (levelCrates[i] + hashMap.get(i + 1)).trim());
            }
        }

        scanner.close();
        return hashMap;
    }
}
