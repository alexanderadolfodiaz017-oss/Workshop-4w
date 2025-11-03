package com.dealership;

public abstract class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicle;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public String toString() {
        return date + " | " + customerName + " | " + customerEmail + " | " +
                vehicle.getMake() + " " + vehicle.getModel() + " | $" + vehicle.getPrice();
    }
}
