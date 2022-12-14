package com.adventofcode._10.device;

public record Signal(String instruction, int value) {

    @Override
    public String toString() {
        return "Signal[" +
                "instruction=" + instruction + ", " +
                "value=" + value + ']';
    }
}
