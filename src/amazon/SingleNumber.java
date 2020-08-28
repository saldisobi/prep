package amazon;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueSet.contains(nums[i])) {
                uniqueSet.add(nums[i]);
            } else {
                uniqueSet.remove(nums[i]);
            }

        }

        return uniqueSet.iterator().next();

    }
}
