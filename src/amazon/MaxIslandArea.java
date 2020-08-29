package amazon;

class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {

        int maxIslandArea = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int maxAreaHere = getIslandArea(grid, i, j);
                    if (maxAreaHere > maxIslandArea) {
                        maxIslandArea = maxAreaHere;
                    }
                }
            }
        }

        return maxIslandArea;
    }

    private int getIslandArea(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int currentArea = 1;


        currentArea = currentArea + getIslandArea(grid, i++, j);
        currentArea = currentArea + getIslandArea(grid, i--, j);
        currentArea = currentArea + getIslandArea(grid, i, j++);
        currentArea = currentArea + getIslandArea(grid, i, j--);


        return currentArea;
    }

    public static void main(String args[]) {
        int[][] arena = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        new MaxIslandArea().maxAreaOfIsland(arena);
    }
}