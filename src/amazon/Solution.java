package amazon;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {

        int start = 0;

        int end = s.length() - 1;

        char[] stringToChar = s.toCharArray();

        Set<Character> vowels = getVowels();

        while (start < end) {
            while ((start < end) && !(vowels.contains(stringToChar[start]))) {
                start++;
            }

            while ((start < end) && !(vowels.contains(stringToChar[end]))) {
                end--;
            }

            char temp = stringToChar[start];

            stringToChar[start] = stringToChar[end];

            stringToChar[end] = temp;

            start++;
            end--;


        }

        return new String(stringToChar);

    }


    public Set<Character> getVowels() {

        Set<Character> vowels = new HashSet();

        vowels.add('a');

        vowels.add('e');

        vowels.add('i');

        vowels.add('o');

        vowels.add('u');

        return vowels;

    }

    public static void main(String args[]){
        System.out.println(new Solution().reverseVowels("hello"));
    }
}