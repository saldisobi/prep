package algoexpert.amazon;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class TopKFrequent {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                 List<String> wordsToExclude) {


        String[] splited = helpText.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");

        HashSet<String> blockedWords = new HashSet<>();

        List<String> allWords = new ArrayList<>();

        for (int i = 0; i < wordsToExclude.size(); i++) {
            blockedWords.add(wordsToExclude.get(i).toLowerCase());
        }
        for (int i = 0; i < splited.length; i++) {
            if (!blockedWords.contains(splited[i].toLowerCase()))
                allWords.add(splited[i].toLowerCase());
        }
        return topKFrequent(allWords);

    }

    public List<String> topKFrequent(List<String> words) {
        if (words == null || words.size() == 0) {
            return Collections.<String>emptyList();
        }

        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        Trie[] buckets = new Trie[words.size() + 1];
        for (int i = 0; i < words.size() + 1; i++) {
            buckets[i] = new Trie();
        }

        for (String word : map.keySet()) {
            int frequency = map.get(word);
            Trie trie = buckets[frequency];
            trie.add(word);
        }

        List<String> solution = new ArrayList();
        for (int i = buckets.length - 1; i >= 0; i--) {
            Trie trie = buckets[i];
            if (trie.getWords().size() > 0) {
                solution.addAll(trie.getWords());
                break;
            }
        }
        return solution;
    }

    class Trie {
        private TrieNode root = new TrieNode();

        public void add(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                curr.putChildIfAbsent(ch);
                curr = curr.getChild(ch);
            }
            curr.word = str;
        }

        public List<String> getWords() {
            List<String> list = new ArrayList();
            getWords(root, list);
            return list;
        }

        private void getWords(TrieNode n, List<String> list) {
            if (n.word != null) {
                list.add(n.word);
            }
            for (char child = 'a'; child <= 'z'; child++) {
                if (n.children.containsKey(child)) {
                    getWords(n.children.get(child), list);
                }
            }
        }
    }

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap();
        public String word = null;

        public void putChildIfAbsent(char ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
    }

    public static void main(String args[]) {
        List<String> wordsToExclude = new ArrayList<>();

        String str = "Purchase order item help can't find item is too much part of purchase need fix for image item delivered too fast  purchase order too big is purchase coming? Too big why?";


        wordsToExclude.add("help");
        wordsToExclude.add("fix");
        wordsToExclude.add("too");
        wordsToExclude.add("is");
        wordsToExclude.add("of");


        System.out.println(new TopKFrequent().retrieveMostFrequentlyUsedWords(str, wordsToExclude));
    }

}



