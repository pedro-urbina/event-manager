package io.github.pedro_urbina.eventmanager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.List;

public class EventManager {
    public static void main(String[] args) throws Exception {
        CSVUtils csvReader = new CSVUtils();

        String csvFile = "event_attendees.csv";
        int rowIndex = 0;

        Scanner scanner = new Scanner(new File(csvFile));

        while (scanner.hasNext()) {
            List<String> line = csvReader.parseLine(scanner.nextLine());

            if (rowIndex == 0) {
                rowIndex++;
                continue;
            }

            System.out.println("Attendee [name=" + line.get(2) + " zipcode=" + cleanZipcode(line.get(9)) + "]");
        }
        scanner.close();
    }

    public static String cleanZipcode(String zipcode) {
        // if zipcode 5 digits, assume correct
        // if zipcode less than 5 digits, pad with zeroes in front
        while (zipcode.length() < 5) {
            zipcode = "0" + zipcode;
        }
        return zipcode;
    }
}