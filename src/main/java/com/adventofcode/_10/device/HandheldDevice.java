package com.adventofcode._10.device;

import java.util.List;

public class HandheldDevice {

    private final ClockCircuit clockCircuit;
    public HandheldDevice(ClockCircuit clockCircuit) {
        this.clockCircuit = clockCircuit;
    }

    public void pressPowerButton() {

        clockCircuit.run();
    }

    public List<String> getLogOfAllInstructions() {

        return clockCircuit.getLineList();
    }
}
