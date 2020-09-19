package educative.twopointers;

import java.util.Arrays;

public class InPlaceSorting {

    public int[] inPlaceSorting(int[] nums) {

        int start = 0;

        int end = nums.length - 1;

        int i = 0;

        while (i <= end) {

            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, end);
                end--;
            }

        }

        return nums;
    }

    private void swap(int[] nums, int positionOne, int positionTwo) {
        int temp = nums[positionOne];
        nums[positionOne] = nums[positionTwo];
        nums[positionTwo] = temp;

    }

    public static void main(String args[]) {
      int[] nums =   new InPlaceSorting().inPlaceSorting(new int[]{2, 2, 0, 1, 2, 0});
      System.out.println(Arrays.toString(nums));
    }
}
