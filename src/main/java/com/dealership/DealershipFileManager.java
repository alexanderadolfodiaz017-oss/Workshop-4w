package com.dealership;

import java.io.*;
import java.nio.file.Paths;

// VV Below me handles loading and saving dealership inventory (Notes) VV
public class DealershipFileManager {

    // VV Below me stores the CSV safely inside the user's Documents folder (Notes) VV
    private static final String FILE_PATH = Paths.get(
            System.getProperty("user.home"), "Documents", "inventory.csv"
    ).toString();

    // VV Below me loads dealership info + cars from CSV (Notes) VV
    public static Dealership getDealership() {
        Dealership dealership = null;

        try {
            File file = new File(FILE_PATH);

            // VV Below me auto-creates the CSV file if it doesn't exist (Notes) VV
            if (!file.exists()) {
                System.out.println("⚠️ inventory.csv not found. Creating a new one at: " + FILE_PATH);
                file.createNewFile();
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println("LaRusso Auto Group|369 E 12th St, Pittsburg, CA 94565|(925) 427-6300");
                }
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String[] dealerInfo = reader.readLine().split("\\|");
                dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 8) {
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
                }
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error loading file: " + FILE_PATH + " (" + e.getMessage() + ")");
        }

        return dealership;
    }

    // VV Below me saves dealership info + cars to CSV (Notes) VV
    public static void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {

            // VV Below me writes dealership info first VV
            writer.println(dealership.getCompanyName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());

            // VV Below me writes every car to the file VV
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
            }

            System.out.println(" File saved successfully at: " + FILE_PATH);

        } catch (Exception e) {
            System.out.println(" Error saving file: " + e.getMessage());
        }
    }
}
//
//!1