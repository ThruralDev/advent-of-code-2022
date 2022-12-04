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

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            System.out.println(line);

            // TODO: 04.12.22 Take ranges into Strings. 

            // TODO: 04.12.22 Check inclusion of one String with RegEx. 

            // TODO: 04.12.22 Increment sum of result Regex matches.

        }
        // Reveal solution.
        System.out.println(result.getSum());
    }
}
