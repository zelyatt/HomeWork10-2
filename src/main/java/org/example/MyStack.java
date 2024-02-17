package org.example;

import java.util.Arrays;

public class MyStack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    public MyStack(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void push(E value){
        array[size ++] = value;
    }
    public void remove(int index){
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size -1] = null;
        size--;
    }
    public void clear(){
        for (int i = 0; i < size - 1; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size(){
        return size;
    }
    public E peek(){
        return (E) array[size - 1];
    }
    public E pop(){
        E value = (E) array[size - 1];
        array[size - 1] = null;
        size --;
        return value;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("Apple");
        myStack.push("Grape");
        myStack.push("A pineapple");
        myStack.push("Watermelon");
        System.out.println(Arrays.toString(myStack.array));

        myStack.remove(2);
        System.out.println(Arrays.toString(myStack.array));

        System.out.println(myStack.size);

        System.out.println(myStack.peek());

        myStack.pop();
        System.out.println(Arrays.toString(myStack.array));

    }

}