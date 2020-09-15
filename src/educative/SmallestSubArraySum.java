package educative;

public class SmallestSubArraySum {

    public int getSmallestSubArrayForSum(int target, int[] nums) {

        int minCounter = Integer.MAX_VALUE;

        int startPointer = 0;



        int currentSum = 0;


        for (int i = 0; i < nums.length; i++) {
            currentSum +=  nums[i];


            while (currentSum >= target && startPointer < nums.length) {

                int arrayLength = i - startPointer + 1;


                if (arrayLength < minCounter) {
                    minCounter = arrayLength;

                }
                currentSum -= nums[startPointer];

                startPointer++;
            }
        }

        return minCounter;

    }

    public static void main(String args[]) {
        System.out.println(new SmallestSubArraySum().getSmallestSubArrayForSum(7, new int[]{2, 1, 5, 2, 3, 2}));
    }
}
