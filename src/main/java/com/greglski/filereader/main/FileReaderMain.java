package com.greglski.filereader.main;

import com.greglski.filereader.io.FileFilterProcessor;
import com.greglski.filereader.io.FileReader;
import com.greglski.filereader.io.ListOfPersons;

import java.util.List;

public class FileReaderMain {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
//        fileReader.readFile(args[0]);
        List<String> listOfLines = fileReader.readFile("C:\\input\\input.txt");

        ListOfPersons listOfPersons = new ListOfPersons(listOfLines);

        FileFilterProcessor fileFilterProcessor = new FileFilterProcessor(listOfPersons.getPersonList());
        fileFilterProcessor.showNumberOfUsers();
        fileFilterProcessor.filter();


    }
}
