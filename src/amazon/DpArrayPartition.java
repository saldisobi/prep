package amazon;

import java.util.Arrays;

class DpArrayPartition {
    public boolean canPartition(int[] nums) {

        Arrays.sort(nums);

        int start = 0;

        int end = nums.length - 1;


        int startSum = 0;

        int endSum = nums[end];

        while (start < end) {
            while (start < end && startSum <= endSum) {
                startSum += nums[start];
                start++;
            }

            while (start < end && endSum <= startSum) {
                endSum += nums[end];
                end--;
            }
        }



        return startSum == endSum;

    }

    public static void main(String args[]){

        System.out.println(new DpArrayPartition().canPartition(new int[]{3,3,3,4,5}));

    }
}