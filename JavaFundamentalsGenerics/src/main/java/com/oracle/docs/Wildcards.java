package com.oracle.docs;

import java.util.Arrays;
import java.util.List;

public class Wildcards {

    // Upper Bounded Wildcards
    // The upper bounded wildcard, <? extends Foo>, where Foo is any type, matches Foo and any subtype of Foo.
    public static void process(List<? extends Foo> list) {
        for (Foo elem : list) {
            // ...
        }
    }


    public static <T extends Foo> void process2(List<T> list){
        for (Foo elem : list) {
            // ...
        }
    }


    // Unbounded Wildcards
    // When the code is using methods in the generic class that don't depend on the type parameter. For example, List.size or List.clear.
    // In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.

    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
    }



    // Lower Bounded Wildcards
    // Restricts the unknown type to be a specific type or a super type of that type.
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }


    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }

}


class Foo {

}