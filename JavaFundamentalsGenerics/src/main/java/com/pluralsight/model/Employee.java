package com.pluralsight.model;

import lombok.ToString;

@ToString(callSuper = true)
public class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }
}