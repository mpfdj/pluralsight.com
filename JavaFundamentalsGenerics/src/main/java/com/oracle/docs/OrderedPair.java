package com.oracle.docs;

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K k, V v) {
        key = k;
        value = v;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }


    public static void main(String[] args) {
        OrderedPair<String, Integer> p1 = new OrderedPair<>("Hello", 1);
        OrderedPair<String, String> p2 = new OrderedPair<>("Hello", "World");
    }
}
