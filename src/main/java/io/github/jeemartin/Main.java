package io.github.jeemartin;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the absolute directory of the .txt file you want to process: ");
        String fileName;
        try {
            fileName = br.readLine().trim();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input.");
            return;
        }

        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while (line != null) {
                // Checking for negative numbers as well, as the task didn't mention that they can't exist
                Pattern pattern = Pattern.compile("-?\\d+");
                Matcher matcher = pattern.matcher(line);

                if(matcher.results().anyMatch(m -> Integer.parseInt(m.group()) >= 10)){
                    System.out.println(line);
                }

                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Given file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}