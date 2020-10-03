package educative.modifiedbinary;

public class OrderAgnosticBinarySearch {

    public int getNumber(int num, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        boolean isNormalSort = false;

        if (nums[end] > nums[start]) {
            isNormalSort = true;
        }

        while (start < end) {

            int median = (start + end) / 2;

            if (nums[median] == num) {
                return median;
            } else if (nums[median] < num && isNormalSort) {
                start = median;
            } else if (nums[median] > num && isNormalSort) {
                end = median;
            } else if (nums[median] < num && !isNormalSort) {
                end = median;
            } else if (nums[median] > num && !isNormalSort) {
                start = median;
            }

        }

        return -1;

    }

    public static void main(String args[]){
        System.out.println(new OrderAgnosticBinarySearch().getNumber(2,new int[]{4,3,2,1}));
    }
}
