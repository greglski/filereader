package com.greglski.filereader.io;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListOfPersons {

    private List<Person> personList = new ArrayList<>();

    public ListOfPersons(List<String> listOfLines) {
        for (String line : listOfLines) {
            String[] word = line.split(",");
            if (word.length < 4) {
                personList.add(new Person(word[0], word[1], LocalDate.parse(word[2]), "TBA"));
            } else {
                personList.add(new Person(word[0], word[1], LocalDate.parse(word[2]), word[3]));
            }
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
