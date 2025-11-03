package com.dealership;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean finance) {
        super(date, name, email, vehicle);
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        double base = vehicle.getPrice();
        double tax = base * 0.05;
        double processingFee = 295;
        double total = base + tax + processingFee;
        if (finance) total *= 1.1;
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + "|SALE|Total: $" + getTotalPrice();
    }
}
