package educative.modifiedbinary;

public class CeilingOfNumber {

    public int getClosestNumber(int num, int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int bestSoFar = Integer.MIN_VALUE;
        while (start < end) {
            int median = (start + end) / 2;

            if (nums[median] == num) {
                return nums[median];
            } else if (nums[median] > num) {
                if (nums[median] > bestSoFar) {
                    bestSoFar = nums[median];
                }

                start = median;
            } else {
                end = median;
            }

        }
        return bestSoFar;
    }


    public static void main(String args[]){
        System.out.println(new CeilingOfNumber().getClosestNumber(1,new int[]{1,2}));
        System.out.println(new CeilingOfNumber().getClosestNumber(1,new int[]{5,6}));
       // System.out.println(new CeilingOfNumber().getClosestNumber(2,new int[]{1,3,5,}));
      //  System.out.println(new CeilingOfNumber().getClosestNumber(6,new int[]{1,2}));
    }
}
