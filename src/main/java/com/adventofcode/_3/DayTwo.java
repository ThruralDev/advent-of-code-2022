package com.adventofcode._3;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/03-1.txt"));
        Result result = new Result();

        while (scanner.hasNextLine()) {

            // Build a String of all de-duplicated compartmentItems of each elve.
            StringBuilder groupItems = new StringBuilder();
            for(int i = 0; i < 3; i++){
                String line = scanner.nextLine();
                groupItems.append(Util.eliminateDuplicates(line));
            }

            // Sort chars in string alphabetically.
            String sortedGroupItems = groupItems.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            // Identify triplicate occurrences.
            String pattern = "((.)\\2*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(sortedGroupItems);
            String badge = null;

            while (m.find()) {
                if (m.group(1).length() == 3) {
                    badge = String.valueOf(m.group(1).charAt(0));
                }
            }
            assert badge != null;

            // Convert char into numeric value as priority.
            String priorityString = Const.ALPHABET + Const.ALPHABET.toUpperCase();
            int priority = priorityString.indexOf(badge) + 1;

            // Append value to sum.
            result.addToSum(priority);
        }
        // Reveal solution.
        System.out.println("The sum of the badge values is : " + result.getSum());
    }
}
