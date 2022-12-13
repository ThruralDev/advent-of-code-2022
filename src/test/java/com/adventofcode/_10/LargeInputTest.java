package com.adventofcode._10;

import com.adventofcode._10.device.HandheldDevice;
import com.adventofcode._10.device.Processor;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LargeInputTest {

    HandheldDevice handheldDevice;

    public LargeInputTest() throws IOException {

        handheldDevice = new HandheldDevice(
                new Processor(Const.RESOURCE_TEST_PATH + "10/larger.txt")
        );
    }

    @Test
    public void checkIfSignalStrengthSumIsRight(){
        handheldDevice.pressPowerButton();
        Assertions.assertEquals(handheldDevice.readSignalStrengthSum(), 13140);
    }
}
