package countdown.treengraph;

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> list = new ArrayList<>();


    int index = 0;

    public void offer(int data) {
        list.add(index, data);
        bubbleUp(index);
        index++;

    }

    private void bubbleUp(int index) {
        while (list.get(index) > list.get(index / 2)){

            int temp =  list.get(index);

        }
    }


}
