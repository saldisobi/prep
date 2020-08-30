package amazon;

public class WallsAndGate {

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    //we have found gates , lets update all reachable values form here
                    updateReachabilityCount(i, j, rooms, 0);
                }
            }
        }
    }

    private void updateReachabilityCount(int i, int j, int[][] rooms, int count) {
        if (i < 0 || j < 0 || i > rooms.length || j > rooms.length || rooms[i][j] < count) {
            //rooms[i][j] < count this check does two things 1. won't update if anything is already smaller
            // -1 walls are smaller so takes care of that case

            return;
        }

        rooms[i][j] = count;

        updateReachabilityCount(i + 1, j, rooms, count + 1);
        updateReachabilityCount(i - 1, j, rooms, count + 1);
        updateReachabilityCount(i, j - 1, rooms, count + 1);
        updateReachabilityCount(i, j + 1, rooms, count + 1);

    }
}
