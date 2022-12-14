package com.adventofcode._10.device;

import java.util.List;

public class HandheldDevice {

    private final Processor processor;
    public HandheldDevice(Processor clockCircuit) {
        this.processor = clockCircuit;
    }

    public void pressPowerButton() {

        processor.run();
    }

    public List<String> getLogOfAllInstructions() {

        return processor.getLineList();
    }

    public int readSignalStrengthSum(){

        return processor.getSignalStrengthSum();
    }

    public List<Signal> readProcessedSignals(){

        return processor.getSignalList();
    }

    public int readRegistrar() {

        return processor.getRegistrar();
    }

    public List<String> readDisplayLines() {

        return processor.getDisplayLineList();
    }
}
