package tricky;

import java.util.HashSet;
import java.util.Stack;

class FrogJumps {
    public boolean canCross(int[] stones) {
        // if distance is more than twice lets say you are at 3rd stone max you jumped to reach here is 2
        // because from zero you can take only 1 step to 1st stone and  max 2 steps to reach 3
        // and max 3 steps to reach 6
        // if next stone is 7  you can't reach here
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }

        HashSet<Integer> stonePositions = new HashSet<>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }

        Stack<Integer> positions = new Stack<>();

        Stack<Integer> jumps = new Stack<>();

        positions.add(0);// we start at 0

        jumps.add(0);// we did not take any step yet

        while (!positions.isEmpty()) {
            int position = positions.pop();

            int jumpDistance = jumps.pop();

            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                if (i <= 0) {
                    continue;
                }

                int nextPosition = position + i;
                if (nextPosition == stones[stones.length-1]) {
                    return true;
                } else if (stonePositions.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}