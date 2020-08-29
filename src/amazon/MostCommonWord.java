package amazon;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet();


        HashMap<String, Integer> wordCountMap = new HashMap();

        int maxCount = 0;

        String maxWord = "";

        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        String[] wordsInParaGraph =

        paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        for (int i = 0; i < wordsInParaGraph.length; i++) {
            if (!bannedSet.contains(wordsInParaGraph[i])) {
                int currentCounter = wordCountMap.getOrDefault(wordsInParaGraph[i], 0);
                currentCounter++;
                wordCountMap.put(wordsInParaGraph[i].toLowerCase(), currentCounter);
            }
        }

        for (Map.Entry<String, Integer> mapEntry : wordCountMap.entrySet()) {

            if (mapEntry.getValue() > maxCount) {
                maxCount = mapEntry.getValue();
                maxWord = mapEntry.getKey();
            }

        }

        return maxWord;
    }

    public static void main(String args[]) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       System.out.println( new MostCommonWord().mostCommonWord(paragraph, new String[]{"hit"}));
    }
}