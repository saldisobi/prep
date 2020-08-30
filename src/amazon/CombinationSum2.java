package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this won't pass test cases on leetcode but i have achieved learning and experiment so not changing it
 */
class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList();

        Arrays.sort(candidates);

        someRecursive(candidates, 0, target, new ArrayList(), result);

        return result;

    }


    public void someRecursive(int[] candidates, int index, int targetSum, List<Integer> currentList, List<List<Integer>> result) {

        if (targetSum == 0) {
            //we found result lets add it
            result.add(currentList);
            return;
        }

        if (targetSum < 0) {

            return;
        }

        if (index == candidates.length) {
            return;
        }


        ArrayList currentListCopy = new ArrayList(currentList);

        currentListCopy.add(candidates[index]);

        int nextIndex = index + 1;
        while (nextIndex < candidates.length - 1 && candidates[index] == candidates[nextIndex]) {
            nextIndex++;
        }
        if (nextIndex <= candidates.length) {
            someRecursive(candidates, nextIndex, targetSum - candidates[index], currentListCopy, result);

            someRecursive(candidates, nextIndex, targetSum, currentList, result);
        }

    }
}