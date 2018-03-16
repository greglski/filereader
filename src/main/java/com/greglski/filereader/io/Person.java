package com.greglski.filereader.io;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class Person {
    String firstname;
    String lastname;
    LocalDate birthdate;
    String phoneNumber;

    public Person(String firstname, String lastname, LocalDate birthdate, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phoneNumber = Optional.ofNullable(phoneNumber).orElse("TBA");
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
