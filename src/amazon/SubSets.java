package amazon;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        fillAllSubsets(nums, result, new ArrayList<Integer>(), 0);

        return result;

    }

    private void fillAllSubsets(int[] nums, List<List<Integer>> result, ArrayList<Integer> current, int index) {
        if (index == nums.length - 1) {
            result.add(new ArrayList<>(current));
            current.add(nums[index]);
            result.add(new ArrayList<>(current));
        } else {

            fillAllSubsets(nums, result, new ArrayList<>(current), index + 1);
            current.add(nums[index]);
            fillAllSubsets(nums, result, new ArrayList<>(current), index + 1);
        }
    }
}
