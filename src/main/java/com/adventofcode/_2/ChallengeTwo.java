package com.adventofcode._2;

import com.adventofcode.util.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChallengeTwo {

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
            int enemyValue = enemyAndMyValue / 10;
            int myValue = enemyAndMyValue % 10;

            // Accounting score.
            switch (myValue) {
                case 1 -> sum += 0;
                case 2 -> {
                    sum += 3;
                    sum += enemyValue;
                }
                case 3 -> sum += 6;
            }
        }
        System.out.println(sum);
    }
}
