package amazon;

class HouseRobber {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] heistBounty = new int[nums.length];

        heistBounty[0] = nums[0];

        heistBounty[1] = Math.max(nums[0], nums[1]);

        for (int j = 2; j < nums.length; j++) {
            heistBounty[j] = Math.max((nums[j] + heistBounty[j - 2]), heistBounty[j - 1]);
        }

        return heistBounty[nums.length-1];

    }

    public static void main(String args[]) {
       System.out.println( new HouseRobber().rob(new int[]{1, 2, 3, 1}));
    }
}