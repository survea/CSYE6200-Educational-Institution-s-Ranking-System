/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diksha Godse
 */
public class FileUtil {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
//    private static final String FILE_HEADER = "Id,FirstName,LastName,Age,GPA";

    public static <E> void writeCsvFile(List<String> studentList, String fileName) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            // Write the CSV file header
//            fileWriter.append(FILE_HEADER.toString());

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new student object list to the CSV file
            for (String student : studentList) {
                fileWriter.append(student);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("\n-------'FileIODemo' CSV file created successfully !!!-------");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    public static List<String> readCsvFile(String fileName) {

        BufferedReader fileReader = null;
        List<String> studentCsvList = new ArrayList<>();

        try {

            // Create a new list of student to be filled by CSV file data
            String line = "";

            // Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            // Read the CSV file header to skip it
            fileReader.readLine();

            // Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                // Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    studentCsvList.add(line);
                }
            }

            // Print the new student list
            System.out.println(
                    "\n--------Reading data from 'FileIODemo' file without converting to student object--------");
            for (String student : studentCsvList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return studentCsvList;
    }
}
