package com.adventofcode._10.device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {

    private int currentSpriteMiddle = 1;
    List<Integer> spritePixelPositions = new ArrayList<>(){{
        for(int i = 0; i < Config.SPRITE_WIDTH; i++){
            add(i);
        }
    }};
    private String displayStream = "";

    public Display() {
    }

    public String getDisplayStream() {
        return displayStream;
    }

    /**
     * @param offset value to change position of sprite middle point as int.
     */
    public void updateSpriteMiddle(int offset){

        this.currentSpriteMiddle += offset;
        updateSpritePixelPositions(this.currentSpriteMiddle);
    }

    /**
     * Based on the sprite middle point and overwrite the values inside of tracking list.
     * @param spriteMiddle passed from the updateSpriteMiddle-Function to keep track and do operations.
     */
    public void updateSpritePixelPositions(int spriteMiddle){

        for(int i = 0; i < Config.SPRITE_WIDTH; i++){

            spritePixelPositions.set(i, spriteMiddle + (i - 1));
        }
    }

    /** Whether the cycle index lay on the sprite.
     * @param cycle of current operation needed for check with sprite-middle.
     */
    public void addToDisplayStream(int cycle){

        int currentRowIndex = (cycle - 1) % Config.DISPLAY_WIDTH;
        boolean containedInSpritePixels = spritePixelPositions.stream().anyMatch(el -> el == currentRowIndex);
        if(containedInSpritePixels) {
            displayStream += "#";
        }else {
            displayStream += ".";
        }
    }

    public void renderPicture(String displayStream) {

        Arrays.stream(displayStream.split("(?<=\\G.{40})")).toList().forEach(System.out::println);
    }
}
