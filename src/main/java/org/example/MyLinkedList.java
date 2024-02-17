package org.example;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        E data;
        Node previous;
        Node next;

        public Node(E value) {
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

    public void add(E value) {
        Node newNode = new Node(value);
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

    public boolean clear() {
        head = null;
        tail = null;
        size = 0;
        return false;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        Node current = head;
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
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
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
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
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

        System.out.println(myLinkedList.size);

        System.out.println(myLinkedList.get(2));

        System.out.println(myLinkedList.clear());
    }
}