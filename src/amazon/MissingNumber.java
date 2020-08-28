package amazon;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        int numSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum = actualSum + i + 1;
            numSum = numSum + nums[i];

        }

        return actualSum - numSum;

    }

    public static void main(String args[]){
       System.out.println( new MissingNumber().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
