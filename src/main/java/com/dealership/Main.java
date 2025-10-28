package com.dealership;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        //VV Below me is my Dealership(Notes )VV
        //VV It includes the Dealership info in the argument VV
        Dealership Dealer = new Dealership(
                "LaRusso Auto Group",
                "369 E 12th St, Pittsburg, CA 94565",
                "(925) 427-6300");


        //VV Below me I created a list of cars(Objects)(Notes) VV
        Vehicle Chiron = new Vehicle("BUG001", 2022, "Bugatti", "Chiron",
                "Sports", "Black", 500, 3000000);
        Vehicle Corvette = new Vehicle("COR002", 2021, "Chevrolet", "Corvette",
                "Sports", "Red", 12000, 65000);
        Vehicle Camaro = new Vehicle("CAM003", 2019, "Chevrolet", "Camaro",
                "Muscle", "Yellow", 35000, 35000);
        Vehicle Mustang = new Vehicle("MUS004", 2020, "Ford", "Mustang",
                "Muscle", "Orange", 27000, 32000);
        Vehicle A6 = new Vehicle("AUD005", 2021, "Audi", "A6",
                "Luxury", "Grey", 22000, 58000);

        //VV Below me is where I went ahead and "parked" my car on the lot(adds cars into Dealership Inventory)(Notes) VV
        Dealer.addVehicle(Chiron);
        Dealer.addVehicle(Corvette);
        Dealer.addVehicle(Camaro);
        Dealer.addVehicle(Mustang);
        Dealer.addVehicle(A6);

        // VV Below me is basically when one of our salesmen bring you to our car lot to show you "ALL" our vehicles and the details about "EACH ONE"(A.K.A prints details for each vehicle)(Notes) VV
        Dealer.showInventory();

        //VV Below me we load the dealership info + cars from the CSV file (Notes) VV
        Dealership DealerFromFile = DealershipFileManager.getDealership();

        //VV Below me seeds default vehicles ONLY if none were loaded (Notes) VV
        if (DealerFromFile.getAllVehicles().isEmpty()) {
            Vehicle Chiron2 = new Vehicle("BUG001", 2022, "Bugatti", "Chiron", "Sports", "Black", 500, 3000000);
            Vehicle Corvette2 = new Vehicle("COR002", 2021, "Chevrolet", "Corvette", "Sports", "Red", 12000, 65000);
            Vehicle Camaro2 = new Vehicle("CAM003", 2019, "Chevrolet", "Camaro", "Muscle", "Yellow", 35000, 35000);
            Vehicle Mustang2 = new Vehicle("MUS004", 2020, "Ford", "Mustang", "Muscle", "Orange", 27000, 32000);
            Vehicle A62 = new Vehicle("AUD005", 2021, "Audi", "A6", "Luxury", "Grey", 22000, 58000);

            DealerFromFile.addVehicle(Chiron2);
            DealerFromFile.addVehicle(Corvette2);
            DealerFromFile.addVehicle(Camaro2);
            DealerFromFile.addVehicle(Mustang2);
            DealerFromFile.addVehicle(A62);

            //VV Below me saves the seeded cars back to CSV so next run loads them automatically (Notes) VV
            DealershipFileManager.saveDealership(DealerFromFile);
        }

        //VV Below me we print the cars that were loaded from the file (Notes) VV
        DealerFromFile.showInventory();

        //VV Below me starts the user interface menu (Notes) VV
        UserInterface ui = new UserInterface(DealerFromFile);
        ui.display();
    }
}
