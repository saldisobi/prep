package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * logic works best
 */
class PartitionLabel {
    public List<Integer> partitionLabels(String S) {

        HashMap<Character, Integer> characterToIndexMap = new HashMap();

        List<Integer> partitions = new ArrayList();

        int indexBuffer = 1;

        for (int i = 0; i < S.length(); i++) {
            characterToIndexMap.put(S.charAt(i), i);
        }

        int currentPartition = -1;
        ;
        for (int i = 0; i < S.length(); i++) {
            if (characterToIndexMap.get(S.charAt(i)) > currentPartition) {
                currentPartition = characterToIndexMap.get(S.charAt(i));
            }

            if (i == currentPartition) {
                if (partitions.size() == 0) {
                    indexBuffer = indexBuffer + currentPartition;
                } else {
                    indexBuffer = currentPartition - indexBuffer;
                }

                partitions.add(indexBuffer);
            }

        }
        return partitions;
    }
}