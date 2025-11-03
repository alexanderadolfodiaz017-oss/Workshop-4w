package com.dealership;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        Scanner input = new Scanner(System.in);
        final String RED = "\u001B[31m", WHITE = "\u001B[37m";
        int choice;
 //k
        do {
            System.out.println("\n" + WHITE + "=== LaRusso Auto Group Dealership Menu ===");
            System.out.println(RED + "We kick the competition!\n");
            System.out.println(RED + "1. " + WHITE + "Show All Vehicles");
            System.out.println(RED + "2. " + WHITE + "Search by Price Range");
            System.out.println(RED + "3. " + WHITE + "Search by Make/Model");
            System.out.println(RED + "4. " + WHITE + "Sell/Lease a Vehicle");
            System.out.println(RED + "5. " + WHITE + "Exit");
            System.out.print(WHITE + "Enter choice: ");

            // prevent input mismatch crash
            while (!input.hasNextInt()) {
                System.out.print(RED + "Please enter a valid number: " + WHITE);
                input.next();
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> dealership.showInventory();
                case 2 -> {
                    System.out.print(WHITE + "Min price: ");
                    double min = input.nextDouble();
                    System.out.print(WHITE + "Max price: ");
                    double max = input.nextDouble();
                    input.nextLine();
                    for (Vehicle v : dealership.getVehiclesByPrice(min, max))
                        System.out.println(RED + v.getMake() + " " + v.getModel() + WHITE + " $" + v.getPrice());
                }
                case 3 -> {
                    System.out.print(WHITE + "Make: ");
                    String make = input.nextLine().trim();
                    System.out.print(WHITE + "Model: ");
                    String model = input.nextLine().trim();
                    for (Vehicle v : dealership.getVehiclesByMakeModel(make, model))
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel());
                }
                case 4 -> sellOrLeaseVehicle();
                case 5 -> System.out.println(RED + "Thanks for visiting LaRusso Auto Group!");
                default -> System.out.println(RED + "Invalid option. Try again!");
            }

        } while (choice != 5);

        input.close();
    }

    private void sellOrLeaseVehicle() {
        Scanner input = new Scanner(System.in);
        final String RESET = "\u001B[0m", CYAN = "\u001B[36m", RED = "\u001B[31m", WHITE = "\u001B[37m";

        System.out.print(CYAN + "Enter VIN: " + WHITE);
        Vehicle vehicle = dealership.findVehicleByVin(input.nextLine().trim());
        if (vehicle == null) {
            System.out.println(RED + "Vehicle not found!" + RESET);
            return;
        }

        System.out.print(CYAN + "Customer name: " + WHITE);
        String name = input.nextLine().trim();

        System.out.print(CYAN + "Customer email: " + WHITE);
        String email = input.nextLine().trim();

        System.out.print(CYAN + "Sale or Lease? (S/L): " + WHITE);
        String type = input.nextLine().trim().toUpperCase();

        String today = LocalDate.now().toString();
        Contract contract;

        if (type.equals("S")) {
            System.out.print(CYAN + "Financed? (Y/N): " + WHITE);
            boolean finance = input.nextLine().trim().equalsIgnoreCase("Y");
            contract = new SalesContract(today, name, email, vehicle, finance);
        } else if (type.equals("L")) {
            int yearDiff = LocalDate.now().getYear() - vehicle.getYear();
            if (yearDiff > 3) {
                System.out.println(RED + "Cannot lease vehicles over 3 years old." + RESET);
                return;
            }
            contract = new LeaseContract(today, name, email, vehicle);
        } else {
            System.out.println(RED + "Invalid choice." + RESET);
            return;
        }

        ContractFileManager.saveContract(contract);
        dealership.removeVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println(CYAN + "Transaction complete!" + RESET);
    }
}
