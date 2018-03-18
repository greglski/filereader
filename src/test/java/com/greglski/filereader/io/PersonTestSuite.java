package com.greglski.filereader.io;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

public class PersonTestSuite {
    @Test
    public void testPersonConstructor() {
        //Given
        Person testPerson1;
        Person testPerson2;
        //When
        testPerson1 = new Person("John", "Doe", LocalDate.parse("1989-01-19"), null);
        testPerson2 = new Person("Jan", "Biel", LocalDate.parse("1963-01-29"), "401200300");
        //Then
        Assert.assertEquals("TBA", testPerson1.getPhoneNumber());
        Assert.assertEquals("401200300", testPerson2.getPhoneNumber());
    }

    @Test
    public void testGetAge() {
        //Given
        Person testPerson;
        //When
        testPerson = new Person("Jan", "Biel", LocalDate.parse("1963-01-29"), "401200300");
        int age = Period.between(testPerson.getBirthdate(), LocalDate.now()).getYears();
        //Then
        Assert.assertEquals(age, testPerson.getAge());
    }
}
