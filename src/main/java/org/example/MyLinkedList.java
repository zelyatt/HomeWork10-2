package org.example;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        public Node(T value) {
            this.data = value;
            this.previous = null;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            tail = current.previous;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Apple");
        myLinkedList.add("Grape");
        myLinkedList.add("A pineapple");
        myLinkedList.add("Watermelon");
        System.out.println(myLinkedList);

        myLinkedList.remove(2);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.size());

        System.out.println(myLinkedList.get(2));

        myLinkedList.clear();
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
    }
}
