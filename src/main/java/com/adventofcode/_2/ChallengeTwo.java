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

            switch (line) {
                case "A X" -> sum += 3;
                case "A Y" -> sum += 4;
                case "A Z" -> sum += 8;
                case "B X" -> sum += 1;
                case "B Y" -> sum += 5;
                case "B Z" -> sum += 9;
                case "C X" -> sum += 2;
                case "C Y" -> sum += 6;
                case "C Z" -> sum += 7;
            }
        }
        System.out.println(sum);
    }
}
