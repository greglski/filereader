package com.greglski.filereader.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile(String filePath) {

        List<String> listOfLines = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            listOfLines = Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("No such a file");
        }

        return listOfLines;
    }
}
