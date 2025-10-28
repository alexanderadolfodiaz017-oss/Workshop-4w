package com.dealership;

// VV Below me starts the dealership program (Notes) VV
public class Main {
    public static void main(String[] args) {

        // VV Below me loads dealership info + cars from CSV (Notes) VV
        Dealership DealerFromFile = DealershipFileManager.getDealership();

        // VV Below me shows all cars loaded from file VV
        DealerFromFile.showInventory();

        // VV Below me starts the interactive colorful menu VV
        UserInterface ui = new UserInterface(DealerFromFile);
        ui.display();
    }
}

