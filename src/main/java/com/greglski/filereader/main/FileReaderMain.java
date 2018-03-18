package com.greglski.filereader.main;

import com.greglski.filereader.io.FileFilterProcessor;
import com.greglski.filereader.io.FileReader;
import com.greglski.filereader.io.ListOfPersons;
import com.greglski.filereader.io.Printer;

import java.util.List;

public class FileReaderMain {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> listOfLines = fileReader.readFile(args[0]);

        ListOfPersons listOfPersons = new ListOfPersons(listOfLines);

        FileFilterProcessor fileFilterProcessor = new FileFilterProcessor(listOfPersons.getPersonList());

        Printer printer = new Printer(fileFilterProcessor);
        printer.showNumberOfUsers();
        printer.showEldestUserWithPhone();

    }
}
