package com.adventofcode._8;

import com.adventofcode.util.Const;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class Challenge {

    public static void main(String[] args) throws Exception {

        String file = Const.RESOURCE_PATH + "input/08.txt";
        String terminalLine;
        int edgeLength;
        HashMap<String, Tree> forest = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {

            // Just read first line for initialization.
            br.mark(1);
            edgeLength = br.readLine().length();
            br.reset();

            // Create forest map with tree objects.
            for (int row = 0; (terminalLine = br.readLine()) != null; row++) {
                int col = 0;
                for (int height : Arrays.stream(terminalLine.split("")).mapToInt(Integer::valueOf).toArray()) {
                    forest.put(String.format("%s:%s", row, col), new Tree(height, row, col));
                    col++;
                }
            }
        }

        // Iterate through each interior tree and proof if highest of any direction.
        for (int col = 1; col < edgeLength - 1; col++) {
            for (int row = 1; row < edgeLength - 1; row++) {
                // System.out.printf("Tree at row %s and col %s of forest.\n", row, col);

                // Check every direction.
                int currentHeight = forest.get(String.format("%s:%s", row, col)).getHeight();
                int finalRow = row;
                int finalCol = col;
                int highestTreeNorth;
                boolean isVisible;

                // north path
                boolean isNorthVisible = forest.values().stream()
                        .filter(x -> x.getRow() < finalRow && x.getCol() == finalCol)
                        .mapToInt(Tree::getHeight)
                        .max()
                        .getAsInt() < currentHeight;

                // south path
                boolean isSouthVisible = forest.values().stream()
                        .filter(x -> x.getRow() > finalRow && x.getCol() == finalCol)
                        .mapToInt(Tree::getHeight)
                        .max()
                        .getAsInt() < currentHeight;

                // East path
                boolean isEastVisible = forest.values().stream()
                        .filter(x -> x.getRow() == finalRow && x.getCol() > finalCol)
                        .mapToInt(Tree::getHeight)
                        .max()
                        .getAsInt() < currentHeight;

                // West path
                boolean isWestVisible = forest.values().stream()
                        .filter(x -> x.getRow() == finalRow && x.getCol() < finalCol)
                        .mapToInt(Tree::getHeight)
                        .max()
                        .getAsInt() < currentHeight;

                // Update visible stat of tree.
                isVisible = isNorthVisible || isSouthVisible || isEastVisible || isWestVisible;
                System.out.printf("Is tree with height %s at row %s and col %s visible? %s\n\n", currentHeight, row,
                        col, isVisible);
                Tree updatedTree = forest.get(String.format("%s:%s", row, col));
                updatedTree.setVisible(isVisible);
                forest.put(String.format("%s:%s", row, col), updatedTree);

                // Mark all outer trees as visible.
                forest.entrySet().stream()
                        .filter(x ->
                                x.getValue().getRow() == 0 ||
                                        x.getValue().getRow() == edgeLength - 1 ||
                                        x.getValue().getCol() == 0 ||
                                        x.getValue().getCol() == edgeLength - 1
                        )
                        .forEach(x -> x.getValue().setVisible(true));

                // Solution one.
                int treesVisible = (int) forest.values().stream().filter(x -> x.isVisible()).count();
                System.out.println(treesVisible + " trees are visible!");
            }
        }
    }
}
