package com.pluralsight;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.*;

public class SearchEngineLogger {
    public static void main(String[] args) {
        LocalDateTime launchTime = LocalDateTime.now();
        System.out.println(launchTime);
        Scanner myScanner = new Scanner(System.in);
        System.out.println();

        try {
            while (true) {
                File newFile = new File("logs.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));

                System.out.println("Enter a search term (X to exit): ");
                String search = myScanner.nextLine();

                if (search.equalsIgnoreCase("X")) {
                    LocalDateTime exitTime = LocalDateTime.now();
                    System.out.println(exitTime);
                    break;
                } else {
                    LocalDateTime searchTime = LocalDateTime.now();
                    System.out.println(searchTime);
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
