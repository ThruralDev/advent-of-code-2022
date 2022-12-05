package com.adventofcode.util;

public class Result {

    private Integer sum;
    private int counter;

    public Result() {

        this.sum = 0;
        this.counter = 0;
    }

    public void setSum(Integer sum) {

        this.sum = sum;
    }

    public int getCounter() {

        return counter;
    }

    public void setCounter(int counter) {

        this.counter = counter;
    }

    public Integer getSum() {

        return sum;
    }

    public void incCounter(){
        counter += 1;
    }

    public void addToSum(Integer summand) {

        this.sum += summand;

    }
}
