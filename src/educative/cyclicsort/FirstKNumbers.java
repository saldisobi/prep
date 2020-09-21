package educative.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstKNumbers {

    public List<Integer> getMissingPositiveNumbers(int[] nums) {
//[3, -1, 4, 5, 5]
        // -1 3 4 5 5
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        int currentIndex = 0;

        int currentNum = 1;

        while (currentIndex < nums.length) {

            while (nums[currentIndex] < currentNum) {
                currentIndex++;
            }

            if (nums[currentIndex] != currentNum) {
                result.add(currentNum);
            }

            currentIndex++;
            currentNum++;

        }

        return result;

    }

    public static void main(String args[]) {
        List<Integer> res = new FirstKNumbers().getMissingPositiveNumbers(new int[]{3, -1, 4, 5, 5});

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }
}
