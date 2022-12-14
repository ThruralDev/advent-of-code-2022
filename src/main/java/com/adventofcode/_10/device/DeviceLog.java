package com.adventofcode._10.device;

public class DeviceLog {

    static void showSignalProcessStatus(int registrar, Signal signal, int cycle) {
        System.out.println(
                String.format(
                        "Registrar is now %s while signal %s and cycle %s.", 
                        registrar, 
                        signal, 
                        cycle)
        );
    }

    static void showSignalStrength(int registrar, int cycle) {
        System.out.println(
                String.format(
                        "Current Signal has strength of %s and created with registrar %s and cycle %s", 
                        registrar * cycle, 
                        registrar, 
                        cycle
                )
        );
    }
}
