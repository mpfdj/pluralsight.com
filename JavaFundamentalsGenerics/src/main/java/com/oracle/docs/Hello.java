package com.oracle.docs;


// This is a generic class
// The type variable, T, that can be used anywhere inside the class.

public class Hello<T> {

    public void hello(T t) {
        System.out.println(t + " is a value of " + t.getClass());
    }

    public static void main(String[] args) {
        Hello<String> hello1 = new Hello<>();
        hello1.hello("Hello");

        Hello<Integer> hello2 = new Hello<>();
        hello2.hello(1);  // Boxing

        // Raw types, when mixing legacy code with generic code
        Hello<String> stringHello = new Hello<>();
        Hello rawHello1 = stringHello;  // Ok

        Hello rawHello2 = new Hello();           // rawBox is a raw type of Hello<T>
        Hello<Integer> intHello = rawHello2;     // warning: unchecked conversion


    }
}
