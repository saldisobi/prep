package countdown.bytebybyte;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static Set<Integer> getDuplicates(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;

            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        return resultSet;
    }

    public static void main(String args[]) {
        Set<Integer> res = new FindDuplicates().getDuplicates(new int[]{1, 2, 3});
        Set<Integer> res1 = new FindDuplicates().getDuplicates(new int[]{1, 2, 2});
        Set<Integer> res2 = new FindDuplicates().getDuplicates(new int[]{3, 3, 3});
        Set<Integer> res3 = new FindDuplicates().getDuplicates(new int[]{2, 1, 1, 2});

        for (Integer s : res) {
            System.out.print(s);
        }
        System.out.println();

        for (Integer s : res1) {
            System.out.print(s);
        }

        System.out.println();

        for (Integer s : res2) {
            System.out.print(s);
        }

        System.out.println();

        for (Integer s : res3) {
            System.out.print(s);
        }
    }
}
