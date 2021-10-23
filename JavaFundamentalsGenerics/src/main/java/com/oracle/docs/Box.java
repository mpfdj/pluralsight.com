package com.oracle.docs;


// A type variable with multiple bounds is a subtype of all the types listed in the bound.
// If one of the bounds is a class, it must be specified first.

public class Box<T extends Number & Comparable<T>> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }


    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);  // Autoboxing int

//        Box<String> stringBox = new Box<>(); // String is not within Bound!
    }
}