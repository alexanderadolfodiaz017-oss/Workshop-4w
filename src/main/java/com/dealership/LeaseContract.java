package com.dealership;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String name, String email, Vehicle vehicle) {
        super(date, name, email, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double leaseFee = vehicle.getPrice() * 0.04; // 4% lease fee
        double monthly = (vehicle.getPrice() / 36) + leaseFee;
        return monthly * 36; // total for 3 years
    }

    @Override
    public String toString() {
        return super.toString() + " | LEASE | Total: $" + getTotalPrice();
    }
}
