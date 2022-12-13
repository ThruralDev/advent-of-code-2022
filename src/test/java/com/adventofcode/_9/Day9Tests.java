package com.adventofcode._9;

import com.adventofcode._9.rope.RopeHead;
import com.adventofcode.util.Const;
import com.adventofcode.util.GeneralUtil;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day9Tests {

    List<String> lineList = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        RopeHead rope = new RopeHead(0, 0);
        String file = Const.RESOURCE_TEST_PATH + "09.txt";
        lineList = GeneralUtil.extractLinesOfInputFile(Files.newBufferedReader(Paths.get(file)));
    }

    @Test
    @DisplayName("Check if 13 is result of short test-input.")
    public void CheckIf13IsResultOfShortTestInput() {
        lineList.forEach(System.out::println);
    }
}
