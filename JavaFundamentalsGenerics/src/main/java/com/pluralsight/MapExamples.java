package com.pluralsight;

import com.pluralsight.model.Person;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {


    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Map<String, Person> madMan = new HashMap<>();
        madMan.put(donDraper.getName(), donDraper);
        madMan.put(peggyOlsen.getName(), peggyOlsen);
        madMan.put(bertCooper.getName(), bertCooper);

        madMan.forEach((s, person) -> System.out.println("Key: " + s + " Value: " + person));
    }

}
