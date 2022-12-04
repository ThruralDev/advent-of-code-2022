package com.adventofcode.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class InputUtil {

    public static String identifyDuplicate(String input){

        Set<String> set = new LinkedHashSet<>();
        String duplicate = null;
        for (String item : input.split("")) {
            if (!set.add(item)) {
                duplicate = item;
            }
        }
        return duplicate;
    }

    public static String eliminateDuplicates(String input){
        char[] chars = input.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static String[] divideStringIntoEqualSubstrings(String input, int lSubstrings){

        return input.split("(?<=\\G.{"+lSubstrings+"})");
    }

    public static String pickOneEqualValueOfTwoSequences(String sequenceOne, String sequenceTwo){

        // Eliminate duplicates of chars inside each sequences. Case sensitive!
        String cleanedOne = eliminateDuplicates(sequenceOne);
        String cleanedTwo = eliminateDuplicates(sequenceTwo);

        // Merge sequences.
        String mergedString = cleanedOne + cleanedTwo;

        // Get duplicate.
        return identifyDuplicate(mergedString);
    }
}
