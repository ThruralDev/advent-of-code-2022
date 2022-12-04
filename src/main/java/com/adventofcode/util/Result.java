package com.adventofcode.util;

public class Result {

    private Integer sum;

    public Result() {

        this.sum = 0;
    }

    public Integer getSum() {

        return sum;
    }

    public void addToSum(Integer summand) {

        this.sum += summand;

    }
}
