package com.pluralsight.model;

import lombok.ToString;

@ToString(callSuper = true)
public class Partner extends Person {
    public Partner(String name, int age) {
        super(name, age);
    }
}
