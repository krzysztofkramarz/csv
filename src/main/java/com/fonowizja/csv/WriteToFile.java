package com.fonowizja.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    public static void writeToFile(List<String> values, String path) throws IOException {

        try (FileWriter writer = new FileWriter(path)) {


            for(String line :values){

                writer.append(line);
            }


        }


    }
}
