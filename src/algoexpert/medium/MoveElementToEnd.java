package algoexpert.medium;

import java.util.Arrays;

public class MoveElementToEnd {

    public int[] moveToEnd(int[] input, int num) {

        int startPointer = 0;
        int endPointer = input.length - 1;
        while (startPointer < endPointer) {
            if (input[startPointer] == num && input[endPointer] != num) {
                int temp = input[endPointer];
                input[endPointer] = input[startPointer];
                input[startPointer] = temp;
            } else if (input[startPointer] == num && input[endPointer] == num) {
                endPointer--;
            } else {
                startPointer++;
            }

        }
        return input;
    }

    public static void main(String args[]) {
        int[] numbers = new MoveElementToEnd().moveToEnd(new int[]{2, 1, 2, 2, 2, 3, 4, 2}, 2);
        System.out.println(Arrays.toString(numbers));
    }
}
