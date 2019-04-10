package com.fonowizja.csv;

import org.jfairy.Fairy;
import org.jfairy.producer.person.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    static Fairy fairy = Fairy.create();

    public static void main(String[] args) throws IOException {

        String csvFile = "/home/egzamin/Desktop/egzamin/abc.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (int i = 0; i < 10; i++) {
                CsvGenerator.writeLine(writer, createFakeData());
            }
        }


        ReadFile readFile = new ReadFile();

        List<String> strings = readFile.readFileAndConvertToJSON("/home/egzamin/Desktop/egzamin/abc.csv");
WriteToFile.writeToFile(strings, "/home/egzamin/Desktop/egzamin/json.csv");



    }

    static private List<String> createFakeData() {


//        imie nazwisko pesel mail
        Person person = fairy.person();

        String imie = person.firstName();
        String nazwisko = person.lastName();
        String pesel = person.nationalIdentificationNumber();
        String mail = person.email();

        return Arrays.asList(imie, nazwisko, pesel, mail);


    }
}

