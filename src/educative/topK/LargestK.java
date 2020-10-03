package educative.topK;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestK {

    public int[] getLargestKElements(int[] nums, int K) {
        if (nums == null) {
            return null;
        }

        if (K > nums.length) {
            return nums;
        }

        int[] result = new int[K];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            if (i < K) {
                minHeap.add(nums[i]);
            } else {
                if (minHeap.peek() > nums[i]) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index] = minHeap.remove();
            index++;
        }

        return result;

    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(new LargestK().getLargestKElements(new int[]{1, 3, 4, 6, 7, 99, 18, 0, 78}, 3)));
    }
}
