package countdown.bytebybyte;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {

    public int getConsecutiveArray(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }


        int currentLength = 0;
        int maxLength = 0;
        for (Integer num : nums) {
            if (numbers.contains(num - 1)) {
                // don't bother it is already accounted for
                currentLength = 0;
                continue;
            } else {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }
}
