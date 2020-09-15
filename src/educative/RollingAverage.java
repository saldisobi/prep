package educative;

import java.util.ArrayList;
import java.util.List;

public class RollingAverage {

    public List<Integer> getRollingAverage(int windowSize, int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < windowSize) {
            return new ArrayList();
        }

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < windowSize) {
                currentSum += nums[i];
            } else {
                if (i == windowSize) {
                    result.add(currentSum);
                }
                currentSum = currentSum - nums[i - windowSize] + nums[i];

                result.add(currentSum);
            }


        }

        return result;

    }


    public static void main(String args[]) {
        List rollingSum = new RollingAverage().getRollingAverage(2, new int[]{2, 4, 1, 5, 6, 7, 8});

        System.out.println(rollingSum.toString());
    }
}
