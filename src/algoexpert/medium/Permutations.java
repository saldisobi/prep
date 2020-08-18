package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> getPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        findAllPermutations(nums, 0, result);

        return result;
    }

    private void findAllPermutations(int[] nums, int index, List<List<Integer>> result) {

    }

    public static void main(String args[]) {
        List<List<Integer>> result = new Permutations().getPermutations(new int[]{1, 2, 3});

        System.out.println(result.size());
    }
}
