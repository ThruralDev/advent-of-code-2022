package com.adventofcode._4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Comparison {

    private String sectionOne;
    private String sectionTwo;

    public Comparison() {

        this.sectionOne = "";
        this.sectionTwo = "";
    }

    public void setSectionOne(String startCommaEnd) {

        this.sectionOne = generateRangeString(startCommaEnd);
    }

    public void setSectionTwo(String startCommaEnd) {

        this.sectionTwo = generateRangeString(startCommaEnd);
    }

    public void cleanSections() {

        this.sectionOne = "";
        this.sectionTwo = "";
    }

    private String generateRangeString(String startCommaEnd) {

        int[] numbers = Arrays.stream(startCommaEnd.split("-")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sectionRangeSequence = new StringBuilder();
        for (int item : IntStream.range(numbers[0], numbers[1] + 1).toArray()) {
            sectionRangeSequence.append(item).append("-");
        }
        sectionRangeSequence.replace(sectionRangeSequence.length() - 1, sectionRangeSequence.length(), "");
        return sectionRangeSequence.toString();
    }

    public boolean checkInclusion() {

        return sectionOne.contains(sectionTwo) || sectionTwo.contains(sectionOne);
    }
}
