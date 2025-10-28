package com.dealership;

import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    //VV Below me connects to the dealership data (Notes) VV
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    //VV Below me runs the simple text menu for user (Notes) VV
    public void display() {
        Scanner input = new Scanner(System.in);
        int choice;

        //VV Below me are the color codes used for the menu (Notes) VV
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String WHITE = "\u001B[37m";

        do {
            //VV Below me is the menu header (Notes) VV
            System.out.println("\n" + WHITE + "=== La Russo Auto Group Dealership Menu ===" + RESET);
            System.out.println("\n" + WHITE + "=== We kick the competition ===" + RESET);



            //VV Below me are the menu options (Notes) VV
            System.out.println(RED + "1. " + WHITE + "Show All Vehicles" + RESET);
            System.out.println(RED + "2. " + WHITE + "Search by Price Range" + RESET);
            System.out.println(RED + "3. " + WHITE + "Search by Make/Model" + RESET);
            System.out.println(RED + "4. " + WHITE + "Exit" + RESET);

            System.out.print(WHITE + "Enter choice: " + RESET);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    //VV Below me shows all vehicles in inventory (Notes) VV
                    dealership.showInventory();
                    break;

                case 2:
                    //VV Below me filters vehicles by price range (Notes) VV
                    System.out.print(WHITE + "Min price: " + RESET);
                    double min = input.nextDouble();
                    System.out.print(WHITE + "Max price: " + RESET);
                    double max = input.nextDouble();
                    for (Vehicle v : dealership.getVehiclesByPrice(min, max)) {
                        System.out.println(RED + v.getMake() + " " + v.getModel() + WHITE + " $" + v.getPrice() + RESET);
                    }
                    break;

                case 3:
                    //VV Below me filters vehicles by make/model (Notes) VV
                    System.out.print(WHITE + "Make: " + RESET);
                    String make = input.next();
                    System.out.print(WHITE + "Model: " + RESET);
                    String model = input.next();
                    for (Vehicle v : dealership.getVehiclesByMakeModel(make, model)) {
                        System.out.println(RED + v.getYear() + " " + v.getMake() + " " + v.getModel() + RESET);
                    }
                    break;

                case 4:
                    //VV Below me exits the program (Notes) VV
                    System.out.println(RED + "Thanks for visiting and here’s your bonsai tree! We kick the competition" + RESET);
                    break;

                default:
                    //VV Below me warns user if wrong input (Notes) VV
                    System.out.println(RED + "Invalid option." + RESET);
            }

        } while (choice != 4);

        input.close();
    }
}
