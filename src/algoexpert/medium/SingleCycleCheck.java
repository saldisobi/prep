package algoexpert.medium;

public class SingleCycleCheck {

    public boolean isSingleCycle(int[] nums) {
        int currentPos = 0;

        int visitedCount = 0;

        while (visitedCount < nums.length) {
            if (visitedCount > 0 && currentPos == 0)
                return false;
            visitedCount++;
            currentPos = getCurrentPos(currentPos, nums);
        }

        return currentPos == 0;
    }

    private int getCurrentPos(int currentPos, int[] nums) {
        int jump = nums[currentPos];
        int next = (currentPos + jump) % nums.length;
        return (next >= 0) ? next : next + nums.length;
    }

    public static void main(String args[]) {
        System.out.println(new SingleCycleCheck().isSingleCycle(new int[]{1, 1, 1, 1, 1}));
    }
}
