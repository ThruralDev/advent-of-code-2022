package com.adventofcode._10;

import com.adventofcode._10.device.Processor;
import com.adventofcode._10.device.HandheldDevice;
import com.adventofcode._10.device.Signal;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShortInputTest {

    HandheldDevice handheldDevice;
    List<String> commandList = new ArrayList<>() {{
       add("noop");
       add("addx 3");
       add("addx -5");
    }};
    List<Signal> signalList = new ArrayList<>() {{
        add(new Signal("noop", 0));
        add(new Signal("addx", 3));
        add(new Signal("addx", -5));
    }};

    public ShortInputTest() throws IOException {

        handheldDevice = new HandheldDevice(
                new Processor(Const.RESOURCE_TEST_PATH + "10/short.txt")
        );
        handheldDevice.pressPowerButton();
    }

    @DisplayName("Read commands and compare if list matches properly to command-list.")
    @Test
    public void readCommandsAndCompareIfEqualsCommandList(){

        assertEquals(handheldDevice.getLogOfAllInstructions(), commandList);
    }

    @DisplayName("Check instruction list of signals.")
    @Test
    public void checkInstructionListOfSignals(){

        assertEquals(signalList, handheldDevice.readProcessedSignals());
    }

    @DisplayName("Check if registrar has value of -1 at the end.")
    @Test
    public void checkIfRegistrarIsNegativeOneAtEnd(){

        assertEquals(handheldDevice.readRegistrar(), -1);
    }
}
