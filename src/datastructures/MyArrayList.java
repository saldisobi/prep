package datastructures;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private Object elements[];


    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E data) {
        if (elements.length == size) {
            rampUpCapacity();
        }

        elements[size] = data;
        size++;
    }

    private void rampUpCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void remove(E data) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == data) {
                removeGap(i);
            }
        }
        size--;
        if (size <= (elements.length / 2)) {
            rampDownCapacity();
        }
    }

    public E get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    private void rampDownCapacity() {
        int newSize = (elements.length / 2);
        elements = Arrays.copyOf(elements, newSize);
    }


    private void removeGap(int i) {
        int current = i;
        while (current < elements.length - 1) {
            elements[current] = elements[current + 1];
            current++;
        }

        elements[elements.length - 1] = null;
    }

    public static void main(String args[]) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");

        myArrayList.remove("1");

        for (int i = 0; i < myArrayList.size; i++) {
            System.out.println(myArrayList.get(i));
        }

    }
}
