package educative.mergeintervals;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public List<Pair<Integer, Integer>> mergeIntervals(List<Pair<Integer, Integer>> intervals) {

        List<Pair<Integer, Integer>> result = new ArrayList<>();

        Collections.sort(intervals, (a, b) ->
                Integer.compare(a.getKey(), b.getKey())
        );
        Pair<Integer, Integer> current = intervals.get(0);

        for (int i = 0; i < intervals.size() - 1; i++) {

            if (current.getValue() >= intervals.get(i + 1).getKey()) {
                current = new Pair<>(current.getKey(), Math.max(current.getValue(),intervals.get(i + 1).getValue()));
            } else {
                result.add(current);
                current = intervals.get(i + 1);
            }

        }

        result.add(current);

        return result;
    }

    public static void main(String args[]) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        list.add(new Pair<>(1, 3));
        list.add(new Pair<>(5, 7));
        list.add(new Pair<>(8, 12));
        list.add(new Pair<>(4, 6));
        list = new MergeIntervals().mergeIntervals(list);
        System.out.println(list.get(0).getKey() + " " + list.get(0).getValue());
        System.out.println(list.get(1).getKey() + " " + list.get(1).getValue());
    }
}
