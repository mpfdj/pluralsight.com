package com.pluralsight;

import com.pluralsight.model.Person;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {


    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Set<Person> madMan = new HashSet<>();
        madMan.add(donDraper);
        madMan.add(peggyOlsen);
        madMan.add(donDraper);

        System.out.println(madMan.contains(donDraper));
        System.out.println(madMan.contains(bertCooper));

        madMan.forEach(person -> System.out.println(person));

    }

}
