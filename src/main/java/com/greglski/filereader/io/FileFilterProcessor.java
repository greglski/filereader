package com.greglski.filereader.io;

import java.util.Comparator;
import java.util.List;

public class FileFilterProcessor {
    List<Person> users;

    public FileFilterProcessor(List<Person> users) {
        this.users = users;
    }

    public void showNumberOfUsers() {
        System.out.println("Total number of users: " + users.size());
    }

    public void filter() {
        Comparator<Person> cmp = Comparator.comparing(Person::getBirthdate);
        Person eldestUser = users.stream()
                .filter(u -> !u.getPhoneNumber().equals("TBA"))
                .min(cmp)
                .get();

        System.out.println("The eldest user with phone number is: " +
                eldestUser.getFirstname() + " " +
                eldestUser.getLastname() +
                ", age: " + " " + eldestUser.getAge() +
                ", phone number: " + eldestUser.getPhoneNumber());
    }
}
