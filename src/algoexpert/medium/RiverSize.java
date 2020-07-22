package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSize {

    public List<Integer> getRiverSizes(int[][] rivers) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[rivers.length][rivers[0].length];
        for (int i = 0; i < rivers.length; i++) {
            for (int j = 0; j< rivers[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                traverseNode(i, j, rivers, result, visited);
            }
        }

        return result;
    }

    private void traverseNode(int i, int j, int[][] rivers, ArrayList<Integer> result, boolean[][] visited) {
        int currentSize = 0;
        Stack<Integer[]> myStack = new Stack<>();
        myStack.push(new Integer[]{i, j});
        while (!myStack.isEmpty()) {
            Integer[] currentNode = myStack.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            if (rivers[i][j] == 0) {
                continue;
            }

            currentSize++;

            List<Integer[]> unvisitedNodes = getUnvisitedNodes(i, j, rivers, visited);

            myStack.addAll(unvisitedNodes);
        }

        if (currentSize > 0) {
            result.add(currentSize);
        }
    }

    private List<Integer[]> getUnvisitedNodes(int i, int j, int[][] rivers, boolean[][] visited) {

        List<Integer[]> unvisitedNodes = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNodes.add(new Integer[]{i - 1, j});
        }

        if (i < rivers.length - 1 && !visited[i + 1][j]) {
            unvisitedNodes.add(new Integer[]{i + 1, j});
        }

        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNodes.add(new Integer[]{i, j - 1});
        }
        if (j < visited[i].length - 1 && !visited[i][j + 1]) {
            unvisitedNodes.add(new Integer[]{i, j + 1});
        }

        return unvisitedNodes;

    }

    public static void main(String args[]) {
        int[][] rivers = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        List<Integer> riverSizes = new RiverSize().getRiverSizes(rivers);

        for(int i = 0;i<riverSizes.size();i++){
            System.out.println(riverSizes.get(i));
        }

    }

}
