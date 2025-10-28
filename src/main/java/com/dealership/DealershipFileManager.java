package com.dealership;

import java.io.*;
import java.nio.file.Paths;

public class DealershipFileManager {

    // VV Below me finds CSV file automatically (Notes) VV
    private static final String FILE_PATH = Paths.get(System.getProperty("user.dir"), "inventory.csv").toString();

    // VV Below me loads dealership info + cars from CSV (Notes) VV
    public static Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String[] dealerInfo = reader.readLine().split("\\|");
            dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

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

        } catch (IOException e) {
            System.out.println("Error loading file: " + FILE_PATH + " (" + e.getMessage() + ")");
        }

        return dealership;
    }

    // VV Below me saves dealership info + cars to CSV (Notes) VV
    public static void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {

            writer.println(dealership.getCompanyName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());

            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
            }

            System.out.println("File saved successfully at: " + FILE_PATH);

        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

