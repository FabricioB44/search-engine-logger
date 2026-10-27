package com.pluralsight;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.*;

public class SearchEngineLogger {
    public static void main(String[] args) {
        try {
            LocalDateTime launchTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedLaunchTime = launchTime.format(formatter);

            File newFile = new File("logs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            bufferedWriter.write(formattedLaunchTime + " launch");
            bufferedWriter.newLine();

            System.out.println(formattedLaunchTime);
            Scanner myScanner = new Scanner(System.in);


            while (true) {
                System.out.println("Enter a search term (X to exit): ");
                String search = myScanner.nextLine();

                if (search.equalsIgnoreCase("X")) {
                    LocalDateTime exitTime = LocalDateTime.now();
                    String formattedExitTime = exitTime.format(formatter);
                    bufferedWriter.write(formattedExitTime + " exit");
                    bufferedWriter.close();
                    break;
                } else {
                    LocalDateTime searchTime = LocalDateTime.now();
                    String formattedSearchTime = searchTime.format(formatter);
                    bufferedWriter.write(formattedSearchTime + " search : " + search);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
