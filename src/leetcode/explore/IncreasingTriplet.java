package leetcode.explore;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int increaseCount = 0;

        int lastSmallest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastSmallest) {
                increaseCount++;
                lastSmallest = nums[i];
            } else {
                increaseCount = 1;
            }
            if (increaseCount == 3)
                return true;
        }

        return false;
    }

    public static void main(String args[]) {
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{1, 2, 3, 4, 5}));

        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }
}
