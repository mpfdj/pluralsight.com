package com.pluralsight;

import com.pluralsight.model.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {


    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMan = new ArrayList<>();
        madMan.add(donDraper);
        madMan.add(peggyOlsen);
        madMan.add(bertCooper);

        System.out.println(madMan);
//        madMan.forEach(person -> System.out.println(person));

        Collections.sort(madMan, new AgeComparator());  // Using a comparator class

        System.out.println(madMan);
//        madMan.forEach(person -> System.out.println(person));

        Comparator<Person> cmpName = (p1, p2) -> p1.getName().compareTo(p2.getName());  // Using a lambda
        Collections.sort(madMan, cmpName);
        System.out.println(madMan);

        Collections.sort(madMan, cmpName.reversed());  // Sort alphabetically from z to a
        System.out.println(madMan);

        Comparator<Person> cmpAge = (p1,p2) -> Integer.compare(p1.getAge(), p2.getAge());
        System.out.println("Youngest: " + Collections.min(madMan, cmpAge));
        System.out.println("Oldest: " + Collections.max(madMan, cmpAge));
    }

}
