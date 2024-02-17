package org.example;

public class MyQueue<E> {
    private Node head;
    private Node tail;

    private int size;
    class Node{
        E data;
        Node next;
        public Node(E value){
            this.data = value;
            this.next = null;
        }
    }
    public void add(E value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }
    public boolean clear(){
        head = null;
        tail = null;
        size = 0;
        return false;
    }
    public int size(){
        return size;
    }
    public  E peek(){
        if (head == null){
            return null;
        }     else {
            return head.data;
        }
    }
    public E poll(){
        if (head == null){
            return null;
        }
        E value = head.data;
        head = head.next;
        size --;
        if(tail == null){
            tail = null;

        }
        return value;

    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        MyQueue<E>.Node current = head;
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
        MyQueue <String> myQueue = new MyQueue<>();
        myQueue.add("Apple");
        myQueue.add("Banana");
        myQueue.add("Cherry");

        System.out.println(myQueue);

        System.out.println(myQueue.size);

        System.out.println(myQueue.peek());

        System.out.println(myQueue.poll());

        System.out.println(myQueue.clear());
    }



}