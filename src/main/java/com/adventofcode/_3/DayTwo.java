package com.adventofcode._3;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/03-1.txt"));
        Result result = new Result();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Divide input into two equal length sets and give it to helper function to get the char.
            String[] compartmentContents = Util.divideStringIntoEqualSubstrings(line, line.length()/2);
            String equalItemType = Util.pickOneEqualValueOfTwoSequences(compartmentContents[0], compartmentContents[1]);

            // Convert char into numeric value as priority.
            String priorityString = Const.ALPHABET + Const.ALPHABET.toUpperCase();
            int priority = priorityString.indexOf(equalItemType) + 1;

            // Append value to sum.
            result.addToSum(priority);
        }
        // Reveal solution.
        System.out.println("The sum of all priorities is: " + result.getSum());
    }
}
