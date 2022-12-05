package com.adventofcode._5;

import com.adventofcode.util.Const;
import com.adventofcode.util.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChallengeOne {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/05.txt"));
        Result result = new Result();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            System.out.println(line);
        }
    }

}
