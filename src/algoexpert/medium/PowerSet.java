package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> getPowerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        generatePowerSet(nums, 0, result, new ArrayList<Integer>());
        return result;
    }


    private void generatePowerSet(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> integers) {

        result.add(new ArrayList<>(integers));
        for (int j = i; j < nums.length; j++) {
            integers.add(nums[j]);
            generatePowerSet(nums, j + 1, result, integers);
            integers.remove(integers.size() - 1);
        }
    }
    
    public static void main(String args[]) {
        System.out.println(new PowerSet().getPowerSet(new int[]{1, 2, 3}));
    }
}
