package algoexpert.medium;

import java.util.Arrays;

public class LongestPalindromicSubString {

    public String longestPalindromeString(String s) {

        char[] charArray = getNormalizedArray(s);

        int[] resultArray = new int[charArray.length];

        int index = 0;

        int maxIndex = 0;

        while (index < charArray.length) {
            int left = index - 1;
            int right = index + 1;
            int counterIndex = 0;
            while (left >= 0 && right < charArray.length &&charArray[left] == charArray[right]) {
                left--;
                right++;
                counterIndex++;
            }

            resultArray[index] = counterIndex;

            if (counterIndex > resultArray[maxIndex]) {
                maxIndex = index;
            }

            index++;

        }

        int resStartIndex = maxIndex - resultArray[maxIndex];

        int resEndIndex = maxIndex + resultArray[maxIndex];

        charArray = Arrays.copyOfRange(charArray, resStartIndex, resEndIndex);

        return Arrays.toString(charArray);


    }

    private char[] getNormalizedArray(String s) {
        char[] stringArray = new char[(s.length() * 2) + 1];
        int stringArrayPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            stringArray[stringArrayPointer] = s.charAt(i);
            stringArrayPointer++;
            stringArray[stringArrayPointer] = '%';
            stringArrayPointer++;
        }

        return stringArray;
    }

    public static void main(String args[]) {
        System.out.println(new LongestPalindromicSubString().longestPalindromeString("ababaghsg12345654321ahgagahg"));
        ;
    }
}
