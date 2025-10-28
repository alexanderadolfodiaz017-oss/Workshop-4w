package com.dealership;

import java.util.ArrayList;

public class Dealership {

    // VV Below me are the Dealership fields/attributes (Notes) VV
    // VV Think of these as the "business card" of the dealership — it holds the name, address, and phone VV
    private String CompanyName;
    private String Address;
    private String PhoneNumber;

    // VV Below me is the inventory list (Notes) VV
    // VV This is like the dealership’s parking lot — where all the cars are stored VV
    private ArrayList<Vehicle> inventory;

    // VV Below me is the Dealership Constructor (Notes) VV
    // VV It “builds” a new dealership and sets up its info & creates an empty lot (inventory) VV
    public Dealership(String CompanyName, String Address, String PhoneNumber) {
        inventory = new ArrayList<>(); // Creates an empty lot for cars
        this.CompanyName = CompanyName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    // VV Adds a car to the lot VV
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // VV Opens the gate and returns all cars on the lot VV
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // VV Lets us replace the whole lot (used when loading from file) VV
    public void setAllVehicles(ArrayList<Vehicle> newInventory) {
        this.inventory = newInventory;
    }

    // VV Shows all cars and their details (like a salesperson tour) VV
    public void showInventory() {
        System.out.println("=== Current Vehicle Inventory for " + CompanyName + " ===");
        System.out.println("Address: " + Address + " | Phone: " + PhoneNumber);
        System.out.println("---------------------------------------------");

        for (Vehicle v : inventory) {
            System.out.println(
                    v.getYear() + " " + v.getMake() + " " + v.getModel() +
                            " | Type: " + v.getVehicleType() +
                            " | Color: " + v.getColor() +
                            " | Price: $" + v.getPrice()
            );
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total Cars in Inventory: " + inventory.size());
    }

    // VV Empty parking spots for future features (Phase 1 placeholders) VV
    // VV These don’t do anything yet but will be used later VV
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) { return null; }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) { return null; }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) { return null; }
    public ArrayList<Vehicle> getVehiclesByColor(String color) { return null; }
    public ArrayList<Vehicle> getVehiclesByMileage(double min, double max) { return null; }
    public ArrayList<Vehicle> getVehiclesByVehicleType(String type) { return null; }
    public void removeVehicle(Vehicle vehicle) { /* empty for now */ }
}

