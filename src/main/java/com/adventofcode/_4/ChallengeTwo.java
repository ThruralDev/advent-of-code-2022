package com.adventofcode._4;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChallengeTwo {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/04.txt"));
        Result result = new Result();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            result.incCounter();

            final String[] parts = line.split(",");

            final String[] elveOneStartAndEnd = parts[0].split("-");
            final String[] elveTwoStartAndEnd = parts[1].split("-");

            final int elveOneStart = Integer.parseInt(elveOneStartAndEnd[0]);
            final int elveOneEnd = Integer.parseInt(elveOneStartAndEnd[1]);
            final int elveTwoStart = Integer.parseInt(elveTwoStartAndEnd[0]);
            final int elveTwoEnd = Integer.parseInt(elveTwoStartAndEnd[1]);


            if ((elveOneStart < elveTwoStart && elveOneEnd < elveTwoStart) || elveOneStart > elveTwoEnd && elveOneEnd > elveTwoEnd)
            {
                result.addToSum(1);
            }
        }
        // Reveal solution.
        System.out.println(result.getCounter() - result.getSum());
    }
}
