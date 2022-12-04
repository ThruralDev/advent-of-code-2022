package com.adventofcode._2;

import com.adventofcode.util.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChallengeOne {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/02.txt"));
        Integer sum = 0;

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            int enemyAndMyValue = Integer.parseInt(
                    line
                            .toLowerCase()
                            .trim()
                            .replace("a", "1")
                            .replace("b", "2")
                            .replace("c", "3")
                            .replace("x", "1")
                            .replace("y", "2")
                            .replace("z", "3")
                            .replace(" ", "")
            );

            // Accounting score.
            sum += (enemyAndMyValue % 10);
            if(enemyAndMyValue % 11 == 0) sum += 3;
            else if(enemyAndMyValue == 12 || enemyAndMyValue == 23 || enemyAndMyValue == 31) sum += 6;
        }
        System.out.println(sum);
    }
}
