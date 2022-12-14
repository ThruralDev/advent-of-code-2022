package com.adventofcode._10.device;

import com.adventofcode.util.GeneralUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Processor {

    private int registrar = 1;
    int nextSignalTrigger = 20;
    int cycle = 1;
    private final List<String> lineList;
    private final List<Signal> signalList = new ArrayList<>();
    private final HashSet<Integer> cachedSignalStrengths = new HashSet<>();
    private final Display display = new Display();

    public Processor(String file) throws IOException {

        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
        lineList.forEach(this::mapSignalInfo);
    }


    public List<String> getLineList() {

        return lineList;
    }


    public int getRegistrar() {

        return registrar;
    }


    public int getSignalStrengthSum() {

        return cachedSignalStrengths.stream().mapToInt(Integer::intValue).sum();
    }


    public List<Signal> getSignalList() {

        return signalList;
    }

    private void mapSignalInfo(String line){

        String instruction = line.split(" ")[0];
        boolean hasValue = line.split(" ").length > 1;
        if (hasValue) {
            int value = Integer.parseInt(line.split(" ")[1]);
            signalList.add(new Signal(instruction, value));
        } else {
            signalList.add(new Signal(instruction, 0));
        }
    }


    private void checkOnReachedTrigger() {

        if (cycle == nextSignalTrigger) {
            cachedSignalStrengths.add(registrar * nextSignalTrigger);
            nextSignalTrigger += Config.SIGNAL_INTERVAL;
        }
    }


    public void run() {

        signalList.forEach(signal -> {

            String signalInstruction = signal.instruction();
            int signalValue = signal.value();

            switch (signalInstruction) {

                case "noop" -> {
                    checkOnReachedTrigger();
                    display.addToDisplayStream(cycle);
                    cycle++;
                }
                case "addx" -> {
                    for (int i = 0; i < 2; i++) {
                        checkOnReachedTrigger();
                        display.addToDisplayStream(cycle);
                        cycle++;
                    }
                    registrar += signalValue;
                    display.updateSpriteMiddle(signalValue);
                }
            }
        });
        display.renderPicture(display.getDisplayStream());
        System.out.println("\n\nSum of all signal strengths is " + getSignalStrengthSum());
    }
}
