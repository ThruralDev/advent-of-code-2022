package com.adventofcode._1;

import com.adventofcode.util.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayOne {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Const.RESOURCE_PATH + "input/01-1.txt"));
        List<Integer> caloryList = new ArrayList<>();
        Integer currentSum = 0;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            boolean isElveDone = Objects.equals(line, "");
            if (isElveDone) {
                caloryList.add(currentSum);
                System.out.println("This Elve ate " + currentSum + " calories.");
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(line);
            }
        }
        System.out.println("Highest number is " + Collections.max(caloryList));
        System.out.println("And now the sum 3 highest..");
        Collections.sort(caloryList);
        List<Integer> top3 = new ArrayList<Integer>(caloryList.subList(caloryList.size() -3, caloryList.size()));
        Integer sumTop3 = top3.stream()
                .mapToInt(a -> a)
                .sum();

        System.out.println(sumTop3);
    }
}
