package org.example;

import java.util.*;

import java.util.*;

public class MyArrayList<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E value) {
        array[size++] = value;
    }

    public void removeLastElement(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public void arrayClear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Grape");
        list.add("A pineapple");
        list.add("Watermelon");

        System.out.println(list.get(2));

        System.out.println(Arrays.toString(list.array));
        System.out.println(Arrays.toString(list.array));

        list.removeLastElement(2);
        System.out.println( Arrays.toString(list.array));

        list.arrayClear();
        System.out.println(Arrays.toString(list.array));

        System.out.println(list.size());


    }
}