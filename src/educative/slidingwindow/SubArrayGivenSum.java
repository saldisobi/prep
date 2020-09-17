package educative.slidingwindow;

public class SubArrayGivenSum {


    /**
     * finds length of smallest subarray that sums to given sum
     *
     * @return
     */
    public int getSubArrayWithGivenSum(int[] nums, int sum) {

        int windowEnd = 0;

        int windowSum = 0;

        int windowStart = 0;

        int minArrayLength = Integer.MAX_VALUE;


        while (windowEnd < nums.length) {
            windowSum += nums[windowEnd];


            while (windowSum >= sum) {
                minArrayLength = Math.min(minArrayLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }

            windowEnd++;

        }

        return minArrayLength;

    }

    public static void main(String args[]) {
        System.out.println(new SubArrayGivenSum().getSubArrayWithGivenSum(new int[]{2, 1, 5, 2, 3, 2}, 7));
    }
}
