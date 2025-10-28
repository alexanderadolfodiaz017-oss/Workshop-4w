package com.dealership;

import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    // VV Below me connects the UserInterface to the dealership data (Notes) VV
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    // VV Below me runs the simple text menu for user (Notes) VV
    public void display() {
        Scanner input = new Scanner(System.in);
        int choice;

        // VV Below me are the color codes used for the menu (Notes) VV
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String WHITE = "\u001B[37m";

        do {
            // VV Below me is the menu header (Notes) VV
            System.out.println("\n" + WHITE + "=== LaRusso Auto Group Dealership Menu ===" + RESET);
            System.out.println(WHITE + "=== We kick the competition ===" + RESET);

            // VV Below me are the menu options (Notes) VV
            System.out.println(RED + "1. " + WHITE + "Show All Vehicles" + RESET);
            System.out.println(RED + "2. " + WHITE + "Search by Price Range" + RESET);
            System.out.println(RED + "3. " + WHITE + "Search by Make/Model" + RESET);
            System.out.println(RED + "4. " + WHITE + "Search by Year Range" + RESET);
            System.out.println(RED + "5. " + WHITE + "Search by Color" + RESET);
            System.out.println(RED + "6. " + WHITE + "Search by Mileage Range" + RESET);
            System.out.println(RED + "7. " + WHITE + "Search by Vehicle Type" + RESET);
            System.out.println(RED + "8. " + WHITE + "Add Vehicle" + RESET);
            System.out.println(RED + "9. " + WHITE + "Remove Vehicle" + RESET);
            System.out.println(RED + "10. " + WHITE + "Exit" + RESET);

            System.out.print(WHITE + "Enter choice: " + RESET);
            choice = input.nextInt();
            input.nextLine(); // consume leftover newline

            switch (choice) {
                // VV Below me shows all cars in the dealership (Notes) VV
                case 1:
                    dealership.showInventory();
                    break;

                // VV Below me searches by Price Range (Notes) VV
                case 2:
                    System.out.print(WHITE + "Min price: " + RESET);
                    double minPrice = input.nextDouble();
                    System.out.print(WHITE + "Max price: " + RESET);
                    double maxPrice = input.nextDouble();
                    System.out.println(WHITE + "\n=== Vehicles between $" + minPrice + " and $" + maxPrice + " ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByPrice(minPrice, maxPrice)) {
                        System.out.println(RED + v.getMake() + " " + v.getModel() + WHITE + " $" + v.getPrice() + RESET);
                    }
                    break;

                // VV Below me searches by Make or Model (Notes) VV
                case 3:
                    System.out.print(WHITE + "Make: " + RESET);
                    String make = input.nextLine();
                    System.out.print(WHITE + "Model: " + RESET);
                    String model = input.nextLine();
                    System.out.println(WHITE + "\n=== Search Results for " + make + " " + model + " ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByMakeModel(make, model)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() + RESET);
                    }
                    break;

                // VV Below me searches by Year Range (Notes) VV
                case 4:
                    System.out.print(WHITE + "Enter minimum year: " + RESET);
                    int minYear = input.nextInt();
                    System.out.print(WHITE + "Enter maximum year: " + RESET);
                    int maxYear = input.nextInt();
                    System.out.println(WHITE + "\n=== Vehicles between years " + minYear + " and " + maxYear + " ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByYear(minYear, maxYear)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() + RESET);
                    }
                    break;

                // VV Below me searches by Color (Notes) VV
                case 5:
                    System.out.print(WHITE + "Enter color: " + RESET);
                    String color = input.nextLine();
                    System.out.println(WHITE + "\n=== Vehicles with color: " + color + " ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByColor(color)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() +
                                WHITE + " | " + v.getColor() + " | $" + v.getPrice() + RESET);
                    }
                    break;

                // VV Below me searches by Mileage Range (Notes) VV
                case 6:
                    System.out.print(WHITE + "Min mileage: " + RESET);
                    double minMiles = input.nextDouble();
                    System.out.print(WHITE + "Max mileage: " + RESET);
                    double maxMiles = input.nextDouble();
                    System.out.println(WHITE + "\n=== Vehicles between " + minMiles + " and " + maxMiles + " miles ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByMileage(minMiles, maxMiles)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() +
                                WHITE + " | Miles: " + v.getOdometer() + " | $" + v.getPrice() + RESET);
                    }
                    break;

                // VV Below me searches by Vehicle Type (Notes) VV
                case 7:
                    System.out.print(WHITE + "Enter vehicle type (e.g. SUV, Sports, Truck): " + RESET);
                    String type = input.nextLine();
                    System.out.println(WHITE + "\n=== Vehicles of type: " + type + " ===" + RESET);
                    for (Vehicle v : dealership.getVehiclesByVehicleType(type)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() +
                                WHITE + " | Type: " + v.getVehicleType() + " | $" + v.getPrice() + RESET);
                    }
                    break;

                // VV Below me adds a new vehicle to the lot (Notes) VV
                case 8:
                    System.out.println(WHITE + "Enter new vehicle details:" + RESET);
                    System.out.print("VIN: ");
                    String vin = input.nextLine();
                    System.out.print("Year: ");
                    double year = input.nextDouble();
                    input.nextLine();
                    System.out.print("Make: ");
                    String newMake = input.nextLine();
                    System.out.print("Model: ");
                    String newModel = input.nextLine();
                    System.out.print("Type: ");
                    String newType = input.nextLine();
                    System.out.print("Color: ");
                    String newColor = input.nextLine();
                    System.out.print("Mileage: ");
                    double newMiles = input.nextDouble();
                    System.out.print("Price: ");
                    double newPrice = input.nextDouble();

                    Vehicle newVehicle = new Vehicle(vin, year, newMake, newModel, newType, newColor, newMiles, newPrice);
                    dealership.addVehicle(newVehicle);
                    System.out.println(RED + "Vehicle added successfully!" + RESET);
                    DealershipFileManager.saveDealership(dealership);
                    break;

                // VV Below me removes a vehicle by VIN (Notes) VV
                case 9:
                    System.out.print(WHITE + "Enter VIN of vehicle to remove: " + RESET);
                    String removeVin = input.nextLine();
                    Vehicle toRemove = null;
                    for (Vehicle v : dealership.getAllVehicles()) {
                        if (v.getVin().equalsIgnoreCase(removeVin)) {
                            toRemove = v;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        dealership.removeVehicle(toRemove);
                        System.out.println(RED + "Vehicle removed successfully!" + RESET);
                        DealershipFileManager.saveDealership(dealership);
                    } else {
                        System.out.println(RED + "No vehicle found with that VIN." + RESET);
                    }
                    break;

                // VV Below me exits the program and saves the file (Notes) VV
                case 10:
                    DealershipFileManager.saveDealership(dealership);
                    System.out.println(RED + "Thanks for visiting and here’s your bonsai tree! We kick the competition." + RESET);
                    break;

                default:
                    System.out.println(RED + "Invalid option." + RESET);
            }

        } while (choice != 10);

        input.close();
    }
}
