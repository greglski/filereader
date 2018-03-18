package com.greglski.filereader.io;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileFilterProcessorTestSuite {

    @Test
    public void testCountNumberOfUsers() {
        //Given
        List<Person> testPersons = new ArrayList<>();
        testPersons.add(new Person("Anna", "Górna", LocalDate.parse("1999-01-29"), "TBA"));
        testPersons.add(new Person("Ewa", "Nowak", LocalDate.parse("1989-12-24"), "501200300"));
        testPersons.add(new Person("John", "Doe", LocalDate.parse("1979-02-10"), "501100200"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000000"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "000000000"));
        testPersons.add(new Person("Jan", "Biel", LocalDate.parse("1963-01-29"), "400000000"));

        FileFilterProcessor testFilterProcessor = new FileFilterProcessor(testPersons);
        //When
        int numberOfUsers = testFilterProcessor.getUsers().size();
        //Then
        Assert.assertEquals(6, numberOfUsers);
    }

    @Test
    public void testFilter() {
        //Given
        List<Person> testPersons = new ArrayList<>();
        testPersons.add(new Person("Anna", "Górna", LocalDate.parse("1999-01-29"), "TBA"));
        testPersons.add(new Person("Ewa", "Nowak", LocalDate.parse("1989-12-24"), "501200300"));
        testPersons.add(new Person("John", "Doe", LocalDate.parse("1979-02-10"), "501100200"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000000"));

        FileFilterProcessor testFilterProcessor = new FileFilterProcessor(testPersons);
        //When

        List<Person> oldest = testFilterProcessor.filter();
        //Then
        Assert.assertEquals("Bieliński", oldest.get(0).getLastname());
    }

    @Test
    public void testFilterWithDuplicate() {
        //Given
        List<Person> testPersons = new ArrayList<>();
        testPersons.add(new Person("Anna", "Górna", LocalDate.parse("1999-01-29"), "TBA"));
        testPersons.add(new Person("Ewa", "Nowak", LocalDate.parse("1989-12-24"), "501200300"));
        testPersons.add(new Person("John", "Doe", LocalDate.parse("1979-02-10"), "501100200"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000000"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000000"));

        FileFilterProcessor testFilterProcessor = new FileFilterProcessor(testPersons);
        //When

        List<Person> oldest = testFilterProcessor.filter();
        //Then
        Assert.assertEquals("Bieliński", oldest.get(0).getLastname());
        Assert.assertEquals(2, oldest.size());
    }

    @Test
    public void testFilterDifferentUsersSameAge() {
        //Given
        List<Person> testPersons = new ArrayList<>();
        testPersons.add(new Person("Anna", "Górna", LocalDate.parse("1999-01-29"), "TBA"));
        testPersons.add(new Person("Ewa", "Nowak", LocalDate.parse("1989-12-24"), "501200300"));
        testPersons.add(new Person("John", "Doe", LocalDate.parse("1979-02-10"), "501100200"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000000"));
        testPersons.add(new Person("Jan", "Bieliński", LocalDate.parse("1963-01-29"), "501000002"));
        testPersons.add(new Person("Jan", "Biel", LocalDate.parse("1963-01-29"), "501000001"));

        FileFilterProcessor testFilterProcessor = new FileFilterProcessor(testPersons);
        //When

        List<Person> oldest = testFilterProcessor.filter();
        //Then
//        Assert.assertEquals("Bieliński", oldest.get(0).getLastname());
        Assert.assertEquals(3, oldest.size());
    }
}
