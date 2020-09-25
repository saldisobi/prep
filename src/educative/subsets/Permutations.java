package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> getPermutation(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        generateAllPermutations(0, new ArrayList<>(), nums, result);

        return result;

    }

    private void generateAllPermutations(int index, ArrayList<Integer> current, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(current);
        } else {
            for (int i = 0; i <= current.size(); i++) {
                ArrayList<Integer> newPermutation = new ArrayList<>(current);
                newPermutation.add(i, nums[index]);
                generateAllPermutations(index + 1, newPermutation, nums, result);
            }
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> result = new Permutations().getPermutation(new int[]{1,3,5});

        for (List<Integer> current : result) {
            System.out.println();
            for (Integer num : current) {
                System.out.print(num);
            }
        }
    }
}
