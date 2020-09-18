package educative.twopointers;

import kotlin.Triple;

import java.util.Arrays;

public class TripletSumZero {

    public Triple<Integer, Integer, Integer> getTripletZeroSum(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;

            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];

                if (sum < 0) {
                    start++;

                } else if (sum > 0) {
                    end--;

                } else {
                    return new Triple<>(nums[start], nums[end], nums[i]);
                }
            }
        }

        return null;
    }

    public static void main(String args[]){
       Triple triple =  new TripletSumZero().getTripletZeroSum(new int[]{-5, 2, -1, -2, 3});
       System.out.println(triple.component1());
        System.out.println(triple.component2());
        System.out.println(triple.component3());
    }
}
