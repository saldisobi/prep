package countdown.treengraph;

public class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node == null)
                System.out.println("node is null for " + i);
            if (node.trieNodes[word.charAt(i) - 'a'] == null) {
                node.trieNodes[word.charAt(i) - 'a'] = new TrieNode();
            }

            node = node.trieNodes[word.charAt(i) - 'a'];
        }


        node.isEndOfWord = true;
    }

    public boolean exists(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {

            if (node.trieNodes[word.charAt(i) - 'a'] != null) {
                node = node.trieNodes[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }

        return true;
    }

    class TrieNode {
        // we are considering only 26 characters
        TrieNode[] trieNodes = new TrieNode[26];

        boolean isEndOfWord = false;
    }


    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("saldi");
        System.out.println(trie.exists("saldi1"));
    }
}
