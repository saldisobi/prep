package educative.twoheap;

import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

    public void insertNum(int num) {

        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }


        if (maxHeap.size() >= minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() >= maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return ((maxHeap.peek() + minHeap.peek()) / 2);
        } else {
            return maxHeap.peek();
        }

    }
}
