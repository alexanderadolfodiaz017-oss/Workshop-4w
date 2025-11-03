package com.dealership;

import java.util.ArrayList;

// VV Below me manages dealership info + inventory VV
public class Dealership {

    private String CompanyName;
    private String Address;
    private String PhoneNumber;
    private ArrayList<Vehicle> inventory;

    // VV Below me is my Dealership Constructor (Notes) VV
    public Dealership(String CompanyName, String Address, String PhoneNumber) {
        inventory = new ArrayList<>();
        this.CompanyName = CompanyName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    // VV Below me adds a car to the lot (Notes) VV
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // VV Below me returns all vehicles in the lot (Notes) VV
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // VV Below me shows every car and its details (Notes) VV
    public void showInventory() {
        System.out.println("=== Current Vehicle Inventory for " + CompanyName + " ===");
        System.out.println("Address: " + Address + " | Phone: " + PhoneNumber);
        System.out.println("---------------------------------------------");

        for (Vehicle v : inventory) {
            System.out.println(
                    "VIN: " + v.getVin() + " | " +   // ✅ VIN added
                            v.getYear() + " " + v.getMake() + " " + v.getModel() +
                            " | Type: " + v.getVehicleType() +
                            " | Color: " + v.getColor() +
                            " | Price: $" + v.getPrice()
            );
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total Cars in Inventory: " + inventory.size());
    }

    // VV Below me are short search methods (Notes) VV
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory)
            if (v.getPrice() >= min && v.getPrice() <= max)
                results.add(v);
        return results;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory)
            if (v.getMake().equalsIgnoreCase(make) || v.getModel().equalsIgnoreCase(model))
                results.add(v);
        return results;
    }

    // VV Below me are simple getters for dealership info (Notes) VV
    public String getCompanyName() { return CompanyName; }
    public String getAddress() { return Address; }
    public String getPhoneNumber() { return PhoneNumber; }

    // VV Below me are helper methods VV
    public Vehicle findVehicleByVin(String vin) {
        for (Vehicle v : inventory)
            if (v.getVin().equalsIgnoreCase(vin))
                return v;
        return null;
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
