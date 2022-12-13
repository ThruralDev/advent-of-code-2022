package com.adventofcode._10.device;

import java.util.List;

public class HandheldDevice {

    private final ClockCircuit clockCircuit;
    private Mode mode;

    public HandheldDevice(ClockCircuit clockCircuit) {
        this.clockCircuit = clockCircuit;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void pressPowerButton() {

        setMode(Mode.POWER_ON);
        clockCircuit.run();
    }

    public List<String> getLogOfAllInstructions() {

        return clockCircuit.getLineList();
    }
}
