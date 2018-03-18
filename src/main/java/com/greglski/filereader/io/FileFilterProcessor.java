package com.greglski.filereader.io;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FileFilterProcessor {
    private List<Person> users;

    public FileFilterProcessor(List<Person> users) {
        this.users = users;
    }

    public int countNumberOfUsers() {
        return users.size();
    }

    public List<Person> filter() {
        List<Person> moreEldestUsers = new ArrayList<>();
        Comparator<Person> cmp = Comparator.comparing(Person::getBirthdate);
        try {
            Person eldestUser = users.stream()
                    .filter(u -> !u.getPhoneNumber().equals("TBA"))
                    .min(cmp)
                    .get();

            moreEldestUsers = users.stream()
                    .filter(u -> !u.getPhoneNumber().equals("TBA"))
                    .filter(u -> u.getBirthdate().isEqual(eldestUser.getBirthdate()))
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            System.out.println("Seems there are nobody with any phone");
        }
        return moreEldestUsers;
    }

    public List<Person> getUsers() {
        return users;
    }
}
