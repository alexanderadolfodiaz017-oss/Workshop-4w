🏎️ LaRusso Auto Group Dealership Application
📘 Project Overview

This Java console application simulates a car dealership management system for LaRusso Auto Group.
It allows users to view all vehicles in inventory, search by price or make/model, and manage dealership data through a CSV file.

The system demonstrates Object-Oriented Programming (OOP) concepts such as:

Classes and objects

Constructors

Encapsulation (Getters/Setters)

Lists and loops

File I/O (reading/writing CSV data)

⚙️ Features

✅ Load and save dealership inventory from a .csv file
✅ Display all vehicles in inventory
✅ Search vehicles by price range or make/model
✅ Add new vehicles and automatically save changes
✅ Command-line user interface with colored output
✅ Data persistence between runs

🧱 Project Structure

All files are organized under the com.dealership package.

File	Description
Main.java	Starts the program and runs the dealership UI
Dealership.java	Stores dealership details and the vehicle list
Vehicle.java	Blueprint for creating vehicle objects
DealershipFileManager.java	Loads and saves dealership data from a CSV file
UserInterface.java	Displays menu and handles user choices
🖥️ Sample Output
✅ Showing All Vehicles

⚠️ Invalid Option Example

💻 IntelliJ Project Structure

🧰 Running in IntelliJ

🧩 Technologies Used

Java 17

IntelliJ IDEA Community Edition

ArrayLists

BufferedReader / PrintWriter

ANSI Colors for Console

🚗 How to Run the Program

Clone or download this repository to your computer.

Open it in IntelliJ IDEA.

Make sure you have Java 17 or newer installed.

Run Main.java.

Use the menu to interact with the dealership.

Example options:

1 → Show All Vehicles
2 → Search by Price Range
3 → Search by Make/Model
4 → Exit

📂 CSV File Example
LaRusso Auto Group|369 E 12th St, Pittsburg, CA 94565|(925) 427-6300
BUG001|2022|Bugatti|Chiron|Sports|Black|500|3000000
COR002|2021|Chevrolet|Corvette|Sports|Red|12000|65000
CAM003|2019|Chevrolet|Camaro|Muscle|Yellow|35000|35000
MUS004|2020|Ford|Mustang|Muscle|Orange|27000|32000
AUD005|2021|Audi|A6|Luxury|Grey|22000|58000

👤 Author

Alexander Diaz

 Invalid Input:

<img width="547" height="269" alt="Invalid Option" src="https://github.com/user-attachments/assets/d5b977ee-b71d-436a-ac5f-007d573dc311" />


Car Inventory:

<img width="888" height="527" alt="Inventory of cars" src="https://github.com/user-attachments/assets/f7f6bc0e-d4f8-4fe0-a1b7-baaa3874ea78" />


All my Java classes:

<img width="548" height="243" alt="java classes" src="https://github.com/user-attachments/assets/1d560623-24ac-4f0e-abf7-d3ae11d6dd52" />


Menu:

<img width="1920" height="1080" alt="Main menu" src="https://github.com/user-attachments/assets/217d7785-4ac4-46fe-bdf6-d91c68379e86" />

---

💼 Sales & Leasing System (Part 2 Update)  

Part 2 expands the dealership system with new features that allow selling and leasing vehicles.  

✅ Option 4 added to the main menu → Sell/Lease a Vehicle  
✅ Collects customer name, email, and VIN  
✅ Supports both sale and lease transactions  
✅ Prevents leasing of vehicles older than 3 years  
✅ Removes sold or leased vehicles from inventory automatically  
✅ Saves all contract data to contracts.csv  

🧾 Contract Classes  

SalesContract.java  
– Handles sales transactions, taxes, and optional financing  
– Calculates total price and monthly payments for financed sales  

LeaseContract.java  
– Handles lease transactions  
– Calculates monthly payments, lease fees, and end value  

ContractFileManager.java  
– Appends every new contract to a CSV file located in your Documents folder  

📂 Example contract output:  

SALES|2025-11-03|John Doe|john@example.com|BUG001|2022|Bugatti|Chiron|Sports|Black|500|3000000|150000|100|495|3150595|Y|7050.12  
LEASE|2025-11-03|Jane Smith|jane@example.com|AUD005|2021|Audi|A6|Luxury|Grey|22000|58000|29000|4060|33060|1715.23  
(image)

🧱 Updated Project Structure (Part 2)  

Contract.java – Abstract base for contracts  
SalesContract.java – Calculates sales and financing details  
LeaseContract.java – Calculates leasing details  
ContractFileManager.java – Saves all contracts  
UserInterface.java – Includes “Sell/Lease Vehicle” option  
Main.java – Runs the full dealership system  

 
