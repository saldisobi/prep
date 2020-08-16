package algoexpert.medium;

import java.util.ArrayList;

public class MinHeap {


    private ArrayList<Integer> mHeapArray = new ArrayList<>();


    public void add(int data) {
        mHeapArray.add(data);
        bubbleUp(mHeapArray.size() - 1);
    }

    private void bubbleUp(int pos) {
        if (mHeapArray.get(pos / 2) > mHeapArray.get(pos)) {
            int temp = mHeapArray.get(pos / 2);
            mHeapArray.add(pos / 2, mHeapArray.get(pos));
            mHeapArray.add(pos, temp);
            bubbleUp(pos / 2);
        }
    }


    private Integer get() {
        int smallest = mHeapArray.get(0);
        mHeapArray.add(0, mHeapArray.get(mHeapArray.size() - 1));
        mHeapArray.remove(mHeapArray.size() - 1);
        bubbleDown(0);
        return smallest;
    }

    private void bubbleDown(int pos) {
        if (mHeapArray.get(pos) > mHeapArray.get(2 * pos + 1)) {
            int temp = mHeapArray.get(2 * pos + 1);
            mHeapArray.add(2 * pos + 1, mHeapArray.get(pos));
            mHeapArray.add(pos, temp);
            bubbleDown(2 * pos + 1);
        } else if (mHeapArray.get(pos) > mHeapArray.get(2 * pos + 2)) {
            int temp = mHeapArray.get(2 * pos + 2);
            mHeapArray.add(2 * pos + 2, mHeapArray.get(pos));
            mHeapArray.add(pos, temp);
            bubbleDown(2 * pos + 2);
        }
    }

    public static void main(String args[]) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(10);
        minHeap.add(4);
        minHeap.add(89);
        System.out.println(minHeap.get());
        System.out.println(minHeap.get());
        System.out.println(minHeap.get());

    }
}
