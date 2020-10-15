package countdown.algorithms;

public class MyQuickSort {


    public void sort(int[] mInputArray) {
        quickSort(0, mInputArray.length - 1, mInputArray);

        for (int i = 0; i < mInputArray.length - 1; i++) {
            System.out.println(mInputArray[i] + "");
        }
    }

    private void quickSort(int low, int high, int[] inputArray) {
        if (low < high) {
            int part = partition(low, high,inputArray);
            quickSort(low, part, inputArray);
            quickSort(part + 1, high, inputArray);
        }

    }

    private int partition(int low, int high, int[] mInputArray) {
        int i = low;
        int j = high;
        while (i < j) {
            while (mInputArray[i] < mInputArray[low]) {
                i++;
            }

            while (mInputArray[j] > mInputArray[low]) {
                j--;
            }

            swapInt(i, j,mInputArray);
        }

        swapInt(low, j,mInputArray);

        return j;

    }

    private void swapInt(int i, int j, int[] mInputArray) {
        int temp = mInputArray[i];
        mInputArray[i] = mInputArray[j];
        mInputArray[j] = temp;
    }


    public static void main(String args[]) {
        int[] arr = new int[]{2, 11, 13, 5, 8, 6};
        new MyQuickSort().sort(arr);
    }

}