package com.adventofcode._6;

import com.adventofcode.util.Const;
import com.adventofcode.util.LimitedSizeQueue;
import com.adventofcode.util.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChallengeOne {

    public static void main(String[] args) throws InterruptedException {

        AtomicBoolean isSearching = new AtomicBoolean(true);
        Result result = new Result();
        int markerLen = 14;
        LimitedSizeQueue<String> queue = new LimitedSizeQueue<>(markerLen);

        try (BufferedReader br = Files.newBufferedReader(Paths.get(Const.RESOURCE_PATH + "input/06.txt"))) {
            String line = br.readLine();

            Arrays.stream(line.split("")).forEach(e -> {

                // Queue current element and increment counter of solution.
                result.addToSum(1);
                queue.add(e);

                // Stringify queue values.
                String queueValueString = String.join("", queue);

                // Check on duplicates and full queue.
                Set<String> set = new HashSet<>(Arrays.asList(queueValueString.split("")));
                if (set.size() == markerLen && isSearching.get()) {
                    System.out.println("The starter marker is at position " + result.getSum());
                    isSearching.set(false);
                }
            });
        } catch (IOException e) {

            System.err.format("IOException: %s%n", e);
        }
    }

}
