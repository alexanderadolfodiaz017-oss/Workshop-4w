🚗 LaRusso Auto Group – Java Car Dealership Application

Author: Alexander Diaz
Project Type: Year Up United / Pluralsight Java Workshop (Workbook 4w – v7.0Y)

📖 Project Description

This console-based Car Dealership Management Application simulates a real dealership system that sales managers can use to view and manage vehicle inventory.

The program uses Object-Oriented Programming (OOP) principles and demonstrates:

Class design

File I/O

Collections (ArrayList)

Encapsulation

User interaction via console menus

All dealership data (name, address, phone, and inventory) is stored in a pipe-delimited CSV file (inventory.csv) and is automatically loaded and saved when the program runs.

🧩 Features

✅ Display all vehicles in inventory
✅ Search vehicles by:

Price range

Make / Model

Year range

Color

Mileage

Type (SUV, Truck, Sedan, etc.)

✅ Add new vehicles
✅ Remove vehicles
✅ Auto-save to CSV on exit
✅ User-friendly colored console menu

🧱 Architecture Overview

The program follows a multi-class design:

Class	Description
Vehicle.java	Defines vehicle properties and constructors (VIN, make, model, price, etc.)
Dealership.java	Stores dealership info and manages the ArrayList of Vehicle objects
DealershipFileManager.java	Handles reading/writing of dealership data to/from inventory.csv
UserInterface.java	Manages console display, menus, and user interaction
Main.java	Entry point of the program; initializes and launches the dealership UI
🖥️ Example Console Outpu
