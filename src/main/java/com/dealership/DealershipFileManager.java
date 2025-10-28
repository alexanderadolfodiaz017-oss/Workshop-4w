package com.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    //VV Below me we load the dealership info + vehicles from the CSV file (Notes) VV
    public static Dealership getDealership() {
        Dealership dealership = null;

        try {
            //VV Below me opens the CSV file (Notes) VV
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\alexa\\PluralSight\\GitHub\\Workshop-4w\\LaRussoAutoGroup\\inventory.csv")
            );

            //VV Below me reads the first line for dealership info (Notes) VV
            String[] dealerInfo = reader.readLine().split("\\|");
            dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

            //VV Below me reads and adds each car to inventory (Notes) VV
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

                dealership.addVehicle(v);
            }

            //VV Below me closes the file after loading (Notes) VV
            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        //VV Below me returns the dealership after loading (Notes) VV
        return dealership;
    }
}
