package com.adventofcode.util;

public class Result {

    private Integer sum;
    private int counter;
    private String sequence;


    public Result() {

        this.sum = 0;
        this.counter = 0;
        this.sequence = "";
    }

    public int getCounter() {

        return counter;
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

    public String getSequence() {

        return sequence;
    }

    public void addToSequence(String appendix){

        this.sequence += appendix;
    }
}
