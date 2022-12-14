package com.adventofcode._10;

import com.adventofcode._10.device.HandheldDevice;
import com.adventofcode._10.device.Processor;
import com.adventofcode.util.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RealInputTest {

    HandheldDevice handheldDevice;

    public RealInputTest() throws IOException {

        handheldDevice = new HandheldDevice(
                new Processor(Const.RESOURCE_PATH + "input/10.txt")
        );
    }

    @Test
    public void checkIfSolutionOfPuzzleOneIsRight(){
        handheldDevice.pressPowerButton();
        System.out.println(handheldDevice.readSignalStrengthSum());
        Assertions.assertEquals(handheldDevice.readSignalStrengthSum(), 11720);
    }
}
