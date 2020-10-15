package countdown.algorithms;

public class MergeSort {

    public int[] mergeSort(int[] input) {

        mergeSortRecur(input, 0, input.length - 1);

        return input;

    }

    private void mergeSortRecur(int[] input, int start, int end) {

        if (start < end) {
            int median = (start + end) / 2;

            mergeSortRecur(input, start, median);
            mergeSortRecur(input, median + 1, end);

            merge(input, start, median, end);
        }
    }

    private void merge(int[] input, int start, int median, int end) {

        int leftLength = median - start + 1;

        int rightLength = end - median;

        int[] leftArray = new int[leftLength];

        int[] rightArray = new int[rightLength];


        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = input[start + i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = input[median + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
                input[k] = leftArray[i];
                i++;
            } else {
                input[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            input[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            input[k] = leftArray[j];
            j++;
            k++;
        }
    }
}
