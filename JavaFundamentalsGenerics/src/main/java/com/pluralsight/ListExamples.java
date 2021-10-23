package com.pluralsight;

import com.pluralsight.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {


    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMan = new ArrayList<>();
        madMan.add(donDraper);
        madMan.add(peggyOlsen);
        madMan.add(bertCooper);


        madMan.forEach(person -> System.out.println(person));

    }

}
