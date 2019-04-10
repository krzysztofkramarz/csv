package com.fonowizja.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public List<String> readFileAndConvertToJSON(String path) throws IOException {
        List<String> odczyt = new ArrayList<>();



        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                StringBuilder jsonLine = new StringBuilder();

                String[] values = line.split(",");


                String readyLine = jsonLine.append("{ \"imie\" : \"")
                        .append(values[0])
                        .append("\", \"nazwisko\" : \"")
                        .append(values[1]).append("\", \"pesel\" : \"")
                        .append(values[2])
                        .append("\", \"mail\" : \"")
                        .append(values[3])
                        .append("\" } , \n").toString();

                odczyt.add(readyLine);
            }
        }

        return odczyt;
    }
}

//      pesel mail
//input   John, 31, New York

//    {"imie": "John", "nazwisko":"ariaw", "pesel" : "1231231", "mail" : "asdasdas@asda.pl"}