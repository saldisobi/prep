package algoexpert.amazon;

import java.util.*;

public class LargestItemAssociation {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
    List<String> largestItemAssociation(List<PairString> itemAssociation) {
        List<String> result = new ArrayList<>();
        int groupCount = 0;
        LinkedHashMap<String, Integer> groups = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> groupPriority = new LinkedHashMap();
        for (int i = 0; i < itemAssociation.size(); i++) {
            String first = itemAssociation.get(i).first;

            String second = itemAssociation.get(i).second;

            if (groups.containsKey(first)) {
                groups.put(second, groups.get(first));
                int groupP = groupPriority.get(groups.get(first)) + 1;
                groupPriority.put(groups.get(first), groupP);
            } else if (groups.containsKey(second)) {
                groups.put(first, groups.get(second));
                int groupP = groupPriority.get(groups.get(second)) + 1;
                groupPriority.put(groups.get(second), groupP);
            } else {
                groups.put(first, groupCount);
                groups.put(second, groupCount);
                groupPriority.put(groupCount, 2);

                groupCount++;
            }
        }

        int bestGroup = 0;

        int maxCount = Integer.MIN_VALUE;

        Iterator<Map.Entry<Integer, Integer>> itr = groupPriority.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            if (entry.getValue() > maxCount)
                bestGroup = entry.getKey();
        }


        Iterator<Map.Entry<String, Integer>> itrGrp = groups.entrySet().iterator();

        while (itrGrp.hasNext()) {
            Map.Entry<String, Integer> entry = itrGrp.next();
            if (entry.getValue() == bestGroup)
                result.add(entry.getKey());
        }

        return result;

    }

    public static void main(String args[]) {
        PairString p1 = new PairString("Item1", "Item2");
        PairString p2 = new PairString("Item3", "Item4");

        List<PairString> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        List<String> res = new LargestItemAssociation().largestItemAssociation(list);
        System.out.println(res.size());
    }

    static class PairString {
        String first;
        String second;

        PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}