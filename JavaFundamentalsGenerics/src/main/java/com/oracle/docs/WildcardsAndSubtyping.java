package com.oracle.docs;

import java.util.ArrayList;
import java.util.List;

// https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html
// https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
public class WildcardsAndSubtyping {


    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);        // Autoboxing Integer
        numbers.add(1.0);      // Autoboxing Double
        numbers.add((byte)1);  // Autoboxing Byte

        List<Number> numbers1 = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();
//        numbers1 = integers1;  // Incompatible types

        List<? extends Number> numbers2 = new ArrayList<>();
        List<? extends Integer> integers2 = new ArrayList<>();
        numbers2 = integers2;

    }

}
