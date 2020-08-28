package amazon;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int currentPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentPointer] = nums[i] ;
                currentPointer++;
            }

        }

        return currentPointer;

    }

    public static void main(String args[]) {
        new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3);
    }
}
