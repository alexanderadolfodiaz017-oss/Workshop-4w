package com.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    // VV Reads the CSV file and loads the dealership info + vehicles VV
    public static Dealership getDealership() {
        Dealership dealership = null;

        try {
            // VV Opens the CSV file VV
            // VV Updated with full path so program can find the file VV
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\alexa\\PluralSight\\GitHub\\Workshop-4w\\LaRussoAutoGroup\\inventory.csv")
            );

            // VV First line = dealership info VV
            String[] dealerInfo = reader.readLine().split("\\|");
            dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

            // VV Each next line = one car VV
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                Vehicle v = new Vehicle(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        Double.parseDouble(parts[6]),
                        Double.parseDouble(parts[7])
                );

                // VV Adds the car to the lot VV
                dealership.addVehicle(v);
            }

            reader.close(); // VV Closes file VV

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return dealership; // VV Returns the loaded dealership VV
    }
}