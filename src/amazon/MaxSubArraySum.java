package amazon;


import java.util.HashMap;

class MaxSubArraySum {
    public int solution(int[] A) {


        HashMap<Integer, Integer> sumMap = new HashMap<>();

        int res = 0;

        int currentSum = 0;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];

            if (currentSum == 0) {
                res++;
            }

            if (res > 10000000) {
                return -1;
            }

            if (sumMap.containsKey(currentSum)) {
                res += sumMap.get(currentSum);
            }

            if (res > 10000000) {
                return -1;
            }
            Integer count = sumMap.get(currentSum);

            if (count == null) {
                sumMap.put(currentSum, 1);
            } else {
                sumMap.put(currentSum, count + 1);
            }
        }

        return res;
    }

    public static void main(String args[]) {
        System.out.println(new MaxSubArraySum().solution(new int[]{-2, -2, 4}));
    }
}