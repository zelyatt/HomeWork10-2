package org.example;

import java.util.Arrays;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % table.length;

        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % table.length;

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int index = hash % table.length;

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("Apple", "Red");
        myHashMap.put("Grape", "Purple");
        myHashMap.put("A pineapple", "Yellow");
        myHashMap.put("Watermelon", "Green");

        System.out.println(myHashMap.get("Apple"));
        System.out.println(myHashMap.get("Grape"));

        myHashMap.remove("A pineapple");
        System.out.println(myHashMap.size());
    }
}
