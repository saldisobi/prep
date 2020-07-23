package algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public List<Integer[]> threeNumberSum(int[] nums, int targetSum) {

        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(nums);


        for (int i = 0; i < nums.length-3; i++) {

            if (i == 0 || nums[i] > nums[i - 1]) {
                int sumToFind = targetSum - nums[i];

                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum == sumToFind) {
                        result.add(new Integer[]{nums[i], nums[j], nums[k]});
                       j++;
                    } else if (sum > sumToFind) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        List<Integer[]> result = new ThreeNumberSum().threeNumberSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);

    }
}
