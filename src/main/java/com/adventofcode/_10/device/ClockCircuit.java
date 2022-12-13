package com.adventofcode._10.device;

import com.adventofcode.util.GeneralUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ClockCircuit {

    List<String> lineList;

    public ClockCircuit(String file) throws IOException {

        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
    }

    public void run() {
        lineList.forEach(line -> {

        });
    }

    public List<String> getLineList() {
        return lineList;
    }

    public void setLineList(List<String> lineList) {
        this.lineList = lineList;
    }
}
