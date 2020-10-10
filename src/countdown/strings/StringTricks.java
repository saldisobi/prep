package countdown.strings;

import java.util.Arrays;

public class StringTricks {


    public boolean checkAnagrams(String s1, String s2) {
        int[] s1AsIntArray = new int[26];

        int[] s2AsIntArray = new int[26];
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                s1AsIntArray[s1.charAt(i) - 'a'] = s1AsIntArray[s1.charAt(i) - 'a'] + 1;

                s2AsIntArray[s2.charAt(i) - 'a'] = s1AsIntArray[s2.charAt(i) - 'a'] + 1;
            }
        } else {
            return false;
        }

        return Arrays.equals(s1AsIntArray, s2AsIntArray);
    }

    public char[] reverseStringInPlace(char[] input) {

        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            char temp = input[start];

            input[start] = input[end];

            input[end] = temp;

            start++;
            end--;

        }

        return input;

    }

    public int getNumberFromString(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += Math.pow(10, s.length() - 1 - i) * Character.getNumericValue(s.charAt(s.length() - 1));
        }
        return result;

    }

    public static void main(String args[]) {
        /*char c = 'a';
        int a = (int) c;
        System.out.println("ascii value of " + c + " = " + a);

        char ch = (char) a;

        System.out.println("character value of " + a + " = " + ch);

        int num = Character.getNumericValue('5');

        System.out.println("numeric value of 5 = " + num);*/

        System.out.println(new StringTricks().getNumberFromString("99999"));


        /*System.out.println(new StringTricks().checkAnagrams("eat", "tea"));

        System.out.println(new String(new StringTricks().reverseStringInPlace("eat".toCharArray())));*/
    }
}
