package com.greglski.filereader.io;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListOfPersonsTestSuite {
    @Test
    public void testGetPersonList() {
        //Given
        List<String> testList = new ArrayList<>();
        testList.add("Anna,Górna,1999-01-29");
        testList.add("Ewa,Nowak,1989-12-24,501200200");
        testList.add("John,Doe,1979-02-10,500100200");
        testList.add("Jan,Bieliński,1963-01-29,501200300");
        testList.add("Jan,Bieliński,1963-01-29,000000000");
        testList.add("Jan,Biel,1963-01-29,501200301");
        //When
        ListOfPersons persons = new ListOfPersons(testList);
        List<Person> listCreated = persons.getPersonList();
        //Then
        Assert.assertEquals(6, listCreated.size());
        Assert.assertEquals("TBA", listCreated.get(0).phoneNumber);
        Assert.assertEquals("501200301", listCreated.get(5).phoneNumber);
    }
}
