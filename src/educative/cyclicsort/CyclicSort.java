package educative.cyclicsort;


import java.util.Arrays;

public class CyclicSort {

    public int[] cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                swapInt(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        return nums;
    }

    private void swapInt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String args[]) {
        System.out.println(Arrays.toString(new CyclicSort().cyclicSort(new int[]{2, 3, 3, 0})));
    }
}
