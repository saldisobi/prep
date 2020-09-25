package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> getAllSubsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        generateAllSubsets(result, nums, new ArrayList(), 0);

        return result;

    }

    private void generateAllSubsets(List<List<Integer>> result, int[] nums, ArrayList currentList, int index) {

        if (index == nums.length - 1) {
            result.add(new ArrayList<>(currentList));
            currentList.add(nums[index]);
            result.add(new ArrayList<>(currentList));
            return;
        } else {

            generateAllSubsets(result, nums, new ArrayList<Integer>(currentList), index + 1);
            currentList.add(nums[index]);
            generateAllSubsets(result, nums, new ArrayList<Integer>(currentList), index + 1);
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> result = new Subsets().getAllSubsets(new int[]{1, 5, 3, 3});

        for (List<Integer> res : result) {
            System.out.println();
            for (Integer res1 : res) {
                System.out.print(res1);
            }
        }
    }
}
