
# University Personnel Management System

This Java project was developed as a final assignment for COP 3330 (Object-Oriented Programming) in Spring 2025. It implements a university personnel management system using OOP principles such as inheritance, abstract classes, method overriding, and encapsulation.

## Project Overview

The system manages information for three types of university personnel:

- **Students**
- **Faculty**
- **Staff**

Each type has specific attributes and behaviors, but all inherit from an abstract `Person` class. The application uses a menu-driven interface to allow users to add, search, delete, and print information on personnel.

## Key Features

- **Student tuition calculation** (with GPA-based discount)
- **Faculty and Staff department info display**
- **Validation for IDs** (`LLDDDD` format)
- **Duplicate ID checking**
- **Case-insensitive input handling**
- **Sorting options** for students (by GPA or name)
- **Final report generation** saved to `report.txt`

## Class Structure

- `Person` (abstract) → base class for all personnel
- `Employee` (abstract) → base class for `Faculty` and `Staff`
- `Student`, `Faculty`, and `Staff` → concrete implementations with overridden `print()` methods
- `FinalProject` → contains `main()` method and menu system

## Menu Options

The console-based system provides these options:

1. Enter Faculty Information  
2. Enter Student Information  
3. Print Tuition Invoice for a Student  
4. Print Faculty Information  
5. Enter Staff Information  
6. Print Staff Information  
7. Delete a Person  
8. Exit Program  

At exit, the user is prompted to save a report of all personnel.

## Sample Output

Julia  Alvarez ju1254  
Credit Hours: 7 ($236.45)  
Fees: $52  
Total payment (after discount): &1,707.15  

## Notes

- Input is validated up to 3 times before returning to the main menu.
- The system supports a maximum of 100 personnel entries using an `ArrayList`.
- Exceptions and invalid inputs are gracefully handled to prevent program crashes.
- The program will create a report of the people created and save it to a file.

---

