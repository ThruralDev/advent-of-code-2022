package com.adventofcode._10;


import com.adventofcode._10.device.Processor;
import com.adventofcode._10.device.HandheldDevice;

import java.io.IOException;

public class Challenge {

    /**
     * @param args - path reference to input file from project root.
     * @throws IOException while extracting lines of input file into list.
     */
    public static void main(String[] args) throws IOException {
        HandheldDevice handheldDevice = new HandheldDevice(new Processor(args[0]));
        handheldDevice.pressPowerButton();
    }
}
