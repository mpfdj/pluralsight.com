package com.oracle.docs;


// Class containing a generic method. The type parameter's scope is limited to the method where it is declared.
public class Util {

    public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }


    public static void main(String[] args) {
        OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);


        p1 = new OrderedPair<>(1, "apple");
        p2 = new OrderedPair<>(1, "apple");
        same = Util.compare(p1, p2);
        System.out.println(same);
    }

}


