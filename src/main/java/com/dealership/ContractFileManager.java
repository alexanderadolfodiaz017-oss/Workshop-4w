package com.dealership;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
    private static final String FILE_PATH = System.getProperty("user.home") + "/Documents/contracts.csv";

    public static void saveContract(Contract contract) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            out.println(contract.toString());
            System.out.println("Contract saved to: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
