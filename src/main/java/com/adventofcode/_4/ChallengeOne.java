package com.adventofcode._4;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChallengeOne {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/04.txt"));
        Result result = new Result();
        Comparison comparison = new Comparison();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Take ranges into Strings.
            String[] sectionRanges = line.split(",");
            comparison.setSectionOne(sectionRanges[0]);
            comparison.setSectionTwo(sectionRanges[1]);

            // Check inclusion of one String with RegEx.
            if(comparison.checkInclusion()) result.addToSum(1);

            comparison.cleanSections();
        }
        // Reveal solution.
        System.out.println(result.getSum());
    }
}
