package com.adventofcode._10;

import com.adventofcode._10.device.ClockCircuit;
import com.adventofcode._10.device.HandheldDevice;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShortInputTest {

    HandheldDevice handheldDevice;
    List<String> commandList = new ArrayList<>() {{
       add("noop");
       add("addx 3");
       add("addx -5");
    }};

    public ShortInputTest() throws IOException {

        handheldDevice = new HandheldDevice(
                new ClockCircuit(Const.RESOURCE_TEST_PATH + "10/short.txt")
        );
    }

    @DisplayName("Read commands and compare if list matches properly to command-list.")
    @Test
    public void readCommandsAndCompareIfEqualsCommandList(){

        handheldDevice.pressPowerButton();
        Assertions.assertEquals(handheldDevice.getLogOfAllInstructions(), commandList);
    }
}
