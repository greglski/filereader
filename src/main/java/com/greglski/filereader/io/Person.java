package com.greglski.filereader.io;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

public final class Person {
    private final String firstname;
    private final String lastname;
    private final LocalDate birthdate;
    protected final String phoneNumber;

    protected Person(final String firstname, final String lastname, final LocalDate birthdate, final String phoneNumber) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(birthdate, person.birthdate) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstname, lastname, birthdate, phoneNumber);
    }
}
