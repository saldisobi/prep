package countdown.bytebybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<int[]> getPermutations(int[] nums) {
        List<int[]> result = new ArrayList<>();

        generatePermutations(result, nums, 0);

        return result;
    }

    private void generatePermutations(List<int[]> result, int[] nums, int start) {

        if (start == nums.length) {
            result.add(Arrays.copyOf(nums, nums.length));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                generatePermutations(result, nums, start + 1);
                swap(nums, start, i);
            }
        }


    }

    public List<String> getPermutationsString(String s) {

        List<String> result = new ArrayList<>();

        generatePermutationsString(result, "", s);

        return result;
    }

    private void generatePermutationsString(List<String> result, String prefix, String suffix) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                generatePermutationsString(result, prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1));
            }
        }
    }

    public static void main(String args[]) {
        List<String> result = new Permutations().getPermutationsString("abc");

        for (String res : result) {
            System.out.println(res);
        }

        List<int[]> resArr = new Permutations().getPermutations(new int[]{1,2,3});

       for(int[] re : resArr){
           System.out.println(Arrays.toString(re));
       }

    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


}
