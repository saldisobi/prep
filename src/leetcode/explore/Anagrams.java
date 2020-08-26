package leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramGroup = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> currentGroup = anagramGroup.getOrDefault(key, new ArrayList<>());

            currentGroup.add(strs[i]);

            anagramGroup.put(key, currentGroup);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(anagramGroup.values());
        return res;


    }


    public static void main(String args[]){
        new Anagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
