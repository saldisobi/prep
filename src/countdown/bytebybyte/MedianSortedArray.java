package countdown.bytebybyte;

public class MedianSortedArray {


    public double findMedian(int[] inputOne, int[] inputTwo) {
        if (inputOne.length > inputTwo.length) {
            return findMedian(inputTwo, inputOne);
        }

        int x = inputOne.length;
        int y = inputTwo.length;

        int start = 0;

        int end = x;

        while (start <= end) {
            int partX = (start + end) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int x1 = (partX == 0) ? Integer.MIN_VALUE : inputOne[partX - 1];
            int x2 = (partX == x) ? Integer.MAX_VALUE : inputOne[partX];

            int y1 = (partY == 0) ? Integer.MIN_VALUE : inputTwo[partY - 1];
            int y2 = (partY == y) ? Integer.MAX_VALUE : inputTwo[partY];

            if (x1 < y2 && y1 < x2) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(x1, y1) + Math.min(x2, y2)) / 2;
                } else {
                    return Math.max(x1, y1);
                }
            } else if (x1 > y2) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }


        }
        return -1;
    }
}
