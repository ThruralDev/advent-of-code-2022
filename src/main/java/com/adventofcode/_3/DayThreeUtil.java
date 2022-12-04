package com.adventofcode._3;

import static com.adventofcode.util.GeneralUtil.eliminateDuplicates;
import static com.adventofcode.util.GeneralUtil.identifyDuplicate;

public class DayThreeUtil {

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
