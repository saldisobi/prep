package amazon;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<Pair<Integer, Integer>> pixelsQueue = new LinkedList<>();

        pixelsQueue.add(new Pair(sr, sc));

        System.out.println("pushed in " + sr + "  " + sc);

        while (!pixelsQueue.isEmpty()) {
            Pair<Integer, Integer> pollPair = pixelsQueue.poll();

            System.out.println("polled out " + pollPair.getKey() + "  " + pollPair.getValue());

            int currentColor = image[pollPair.getKey()][pollPair.getValue()];

            if (currentColor != newColor) {
                image[pollPair.getKey()][pollPair.getValue()] = newColor;
                addNeighboursToQueue(pollPair, pixelsQueue, image, newColor);
            }
        }

        return image;


    }

    private void addNeighboursToQueue(Pair<Integer, Integer> pollPair, Queue<Pair<Integer, Integer>> pixelsQueue, int[][] image, int newColor) {
        if ((pollPair.getKey() + 1) < image.length) {
            if (image[pollPair.getKey() + 1][pollPair.getValue()] != newColor) {
                pixelsQueue.add(new Pair<>(pollPair.getKey() + 1, pollPair.getValue()))
            }
        }

        if ((pollPair.getKey() - 1) >= 0) {

            if (image[pollPair.getKey() - 1][pollPair.getValue()] != newColor) {
                pixelsQueue.add(new Pair<>(pollPair.getKey() - 1, pollPair.getValue()));
            }
        }

        if ((pollPair.getValue() + 1) < image[0].length) {
            if (image[pollPair.getKey()][pollPair.getValue() + 1] != newColor) {
                pixelsQueue.add(new Pair<>(pollPair.getKey(), pollPair.getValue() + 1));
            }


        }

        if ((pollPair.getValue() - 1) >= 0) {
            if (image[pollPair.getKey()][pollPair.getValue() - 1] != newColor) {
                pixelsQueue.add(new Pair<>(pollPair.getKey(), pollPair.getValue() + 1));
            }


        }
    }


    public static void main(String args[]) {
        new FloodFill().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        }, 1, 1, 2);

    }
}
