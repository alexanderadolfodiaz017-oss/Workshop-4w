package com.dealership;

public class Vehicle {

    private String vin;
    private double year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double odometer;
    private double price;

    public Vehicle(String vin, double year, String make, String model,
                   String vehicleType, String color, double odometer, double price) {

        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String getVin() { return vin; }
    public double getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getVehicleType() { return vehicleType; }
    public String getColor() { return color; }
    public double getOdometer() { return odometer; }
    public double getPrice() { return price; }
}
