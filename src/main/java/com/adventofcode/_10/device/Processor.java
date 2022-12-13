package com.adventofcode._10.device;

import com.adventofcode.util.GeneralUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Processor {

    private final List<String> lineList;
    private final int registrar = 1;
    private int signalStrength;
    private int signalStrengthSum;

    public Processor(String file) throws IOException {

        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
    }

    public List<String> getLineList() {

        return lineList;
    }

    public void run() {

        lineList.forEach(System.out::println);
    }

    public int getSignalStrength() {

        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {

        this.signalStrength = signalStrength;
    }

    public int getSignalStrengthSum() {

        return signalStrengthSum;
    }

    public void setSignalStrengthSum(int signalStrengthSum) {

        this.signalStrengthSum = signalStrengthSum;
    }
}
