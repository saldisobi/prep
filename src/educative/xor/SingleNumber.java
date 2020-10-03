package educative.xor;

public class SingleNumber {

    public int getSingleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("current as binary"+Integer.toBinaryString(nums[i]));
            num = num ^ nums[i];
            System.out.println(Integer.toBinaryString(num));
        }

        return num;
    }

    public static void main(String args[]) {
        System.out.println("the single no is "+new SingleNumber().getSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
