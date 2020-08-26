package leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] > nums[i - 1]) {
                //we do search only and only if two numbers are not exactly the same unless we want duplicates in result


                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {

                    if (nums[i]+nums[start]+nums[end] == 0) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                    }
                    if (nums[i]+nums[start]+nums[end] < 0 ) {
                        int currentStart = start;

                        while (nums[start] == nums[currentStart] && start < end) {
                            start++;
                        }
                    } else {

                        int currentEnd = end;
                        while (nums[end] == nums[currentEnd]&&start<end){
                            end--;
                        }

                    }
                }

            }


        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}).size());
    }

}
