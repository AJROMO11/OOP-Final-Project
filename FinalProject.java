/*
- Final Project
- AJ Romaniello and Clayton Monfils
- (Optional) Any other notes for the TA
*/

import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {

	public static void main(String[] args) {
		boolean exitProgram = false, idFound = false;
		String option, fullNameInput, idInput, departmentInput, rankInput, statusInput;
		int i;
		Scanner inputScanner = new Scanner (System.in);
		ArrayList<Person> PersonCollection = new ArrayList<Person>(100);
		
		System.out.println("\t\t\t\tWelcome to the Personnel Management System");
		
		while (exitProgram == false) {
			System.out.println("Choose one of the options:");
			System.out.println("1- Enter the information of a faculty");
			System.out.println("2- Enter the information of a student");
			System.out.println("3- Print tuition invoice for a student");
			System.out.println("4- Print faculty information");
			System.out.println("5- Enter the information of a staff member");
			System.out.println("6- Print the information of a staff member");
			System.out.println("7- Delete a person");
			System.out.println("8- Exit Program\n\n");
			System.out.print("Enter your selection: ");
			
			option = inputScanner.nextLine();
			if (option.compareTo("1") == 0) {
				i = 0;
				idFound = false;
				
				// Looping until 3 invalid tries completed
				while (i < 3) {
					System.out.print("Enter faculty info:\nName: ");
					fullNameInput = inputScanner.nextLine();
					System.out.print("ID: ");
					idInput = inputScanner.nextLine();
					
					// Checking for invalid id format
					try {
						if (idInput.length() != 6) {
							throw new idFormatException();
						} 
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					try {
						if (!idInput.subSequence(0, 1).toString().matches("[a-zA-Z]+")) {
							throw new idFormatException();
						}
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					try {
						if (!idInput.subSequence(2, 5).toString().matches("[0-9]+")) {
							throw new idFormatException();
						}
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					
					// Checking for existing id
					try {
						for (Person existingPerson : PersonCollection) {
							if (idInput.compareToIgnoreCase(existingPerson.getId()) == 0) {
								idFound = true;
								break;
							}
						}
						if (idFound) {
							throw new duplicateIDException();
						}
					} catch (duplicateIDException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					System.out.print("Department: ");
					departmentInput = inputScanner.nextLine();
					
					// Checking for invalid department input
					try {
						if (departmentInput.compareToIgnoreCase("Mathematics") != 0) {
							if (departmentInput.compareToIgnoreCase("Engineering") != 0) {
								if (departmentInput.compareToIgnoreCase("English") != 0) {
									throw new departmentInputException();
								}
							}
						}
					} catch (departmentInputException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					System.out.print("Rank: ");
					rankInput = inputScanner.nextLine();
					
					// Checking for invalid rank input
					try {
						if (rankInput.compareToIgnoreCase("Professor") != 0) {
							if (rankInput.compareToIgnoreCase("Adjunct") != 0) {
								throw new rankInputException();
							}
						}
					} catch (rankInputException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					
					PersonCollection.add(new Faculty(fullNameInput, idInput, departmentInput, rankInput));
					System.out.println("Faculty added!");
					break;
				}
			} else if (option.compareTo("2") == 0) {
				
			} else if (option.compareTo("3") == 0) {
				
			} else if (option.compareTo("4") == 0) {
				i = 0;
				idFound = false;
				while (i < 3) {
					System.out.print("Enter the faculty ID: ");
					idInput = inputScanner.nextLine();
					try {
						for (Person existingPerson : PersonCollection) {
							if (idInput.compareToIgnoreCase(existingPerson.getId()) == 0) {
								idFound = true;
								existingPerson.print();
								break;
							}
						}
						if (idFound) {
							break;
						} else {
							throw new noFacultyFoundException();
						}
					} catch (noFacultyFoundException e) {
						e.printMessage();
						System.out.println(idInput);
						i = i + 1;
						continue;
					}
				}
			} else if (option.compareTo("5") == 0) {
				i = 0;
				idFound = false;
				// Looping until 3 invalid tries completed
				while (i < 3) {
					System.out.print("Enter staff info:\nName: ");
					fullNameInput = inputScanner.nextLine();
					System.out.print("ID: ");
					idInput = inputScanner.nextLine();
					
					// Checking for invalid id format
					try {
						if (idInput.length() != 6) {
							throw new idFormatException();
						} 
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					try {
						if (!idInput.subSequence(0, 1).toString().matches("[a-zA-Z]+")) {
							throw new idFormatException();
						}
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					try {
						if (!idInput.subSequence(2, 5).toString().matches("[0-9]+")) {
							throw new idFormatException();
						}
					} catch (idFormatException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					
					// Checking for existing id
					try {
						for (Person existingPerson : PersonCollection) {
							if (idInput.compareToIgnoreCase(existingPerson.getId()) == 0) {
								idFound = true;
								break;
							}
						}
						if (idFound) {
							throw new duplicateIDException();
						}
					} catch (duplicateIDException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					System.out.print("Department: ");
					departmentInput = inputScanner.nextLine();
					
					// Checking for invalid department input
					try {
						if (departmentInput.compareToIgnoreCase("Mathematics") != 0) {
							if (departmentInput.compareToIgnoreCase("Engineering") != 0) {
								if (departmentInput.compareToIgnoreCase("English") != 0) {
									throw new departmentInputException();
								}
							}
						}
					} catch (departmentInputException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					System.out.print("Status: ");
					statusInput = inputScanner.nextLine();
					
					// Checking for invalid status input
					try {
						if (statusInput.compareToIgnoreCase("Part-time") != 0) {
							if (statusInput.compareToIgnoreCase("Full-time") != 0) {
								throw new statusInputException();
							}
						}
					} catch (statusInputException e) {
						e.printMessage();
						i = i + 1;
						continue;
					}
					
					PersonCollection.add(new Staff(fullNameInput, idInput, departmentInput, statusInput));
					System.out.println("Staff added!");
					break;
				}
			} else if (option.compareTo("6") == 0) {
				i = 0;
				idFound = false;
				while (i < 3) {
					System.out.print("Enter the staff ID: ");
					idInput = inputScanner.nextLine();
					try {
						for (Person existingPerson : PersonCollection) {
							if (idInput.compareToIgnoreCase(existingPerson.getId()) == 0) {
								idFound = true;
								existingPerson.print();
								break;
							}
						}
						if (idFound) {
							break;
						} else {
							throw new noStaffFoundException();
						}
					} catch (noStaffFoundException e) {
						e.printMessage();
						System.out.println(idInput);
						i = i + 1;
						continue;
					}
				}
			} else if (option.compareTo("7") == 0) {
				i = 0;
				idFound = false;
				while (i < 3) {
					System.out.print("Enter the person's ID: ");
					idInput = inputScanner.nextLine();
					try {
						for (Person existingPerson : PersonCollection) {
							if (idInput.compareToIgnoreCase(existingPerson.getId()) == 0) {
								idFound = true;
								PersonCollection.remove(existingPerson);
								break;
							}
						}
						if (idFound) {
							break;
						} else {
							throw new noPersonFoundException();
						}
					} catch (noPersonFoundException e) {
						e.printMessage();
						System.out.println(idInput);
						i = i + 1;
						continue;
					}
				}
			} else if (option.compareTo("8") == 0) {
				
				exitProgram = true;
			}
		}
	}
	
}

abstract class Person{
	private String fullName;
	private String id;
	
	public Person(String fullName, String id) {
		setFullName(fullName);
		setId(id);
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public abstract void print();
	
}

abstract class Employee extends Person{
	private String department;
	
	public Employee(String fullName, String id, String department) {
        super(fullName, id);
        setDepartment(department);
    }

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}

class Student extends Person{
	private double gpa;
	private int creditHours;
	
    public Student(String fullName, String id, double gpa, int creditHours) {
        super(fullName, id);
        this.gpa = gpa;
        this.creditHours = creditHours;
    }
    
    public Student(String fullName, String id) {
    	this(fullName, id, 0.0, 0);
    }
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	@Override
	public void print() {
		System.out.println("Student Name: " + getFullName() + 
						   "\tID: " + getId() + "\nGPA: " + gpa + 
						   "\nCredit Hours: " + creditHours +
						   "\nTuition (after discount if applicable): " + calculateTuition());
	}

	public double calculateTuition() {
		double tuition = 236.45 * creditHours + 52;
		if(gpa >= 3.85) {
			tuition *= 0.75;
		}
		return tuition;
	}
	
}

class Faculty extends Employee{
	private String rank;
	
	public Faculty(String fullName, String id, String department, String rank) {
		super(fullName, id, department);
		setRank(rank);
	}

	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public void print() {
		System.out.println("Faculty Information\nFull Name: " + getFullName() +
						 "\nID: " + getId() +
						 "\nDepartment: " + getDepartment() +
						 "\nRank: " + rank);
	}
}

class Staff extends Employee{
	private String status;
	
	public Staff(String fullName, String id, String department, String status){
		super(fullName, id, department);
		setStatus(status);
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public void print() {
		System.out.println("Staff Information\nFull Name: " + getFullName() +
				 		   "\nID: " + getId() +
				 		   "\nDepartment: " + getDepartment() +
				 		   "\nStatus: " + status);
	}
}

class idFormatException extends Exception {
	public void printMessage() {
		System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit");
		System.out.println("\n\nTry again!");
	}
}

class duplicateIDException extends Exception {
	public void printMessage() {
		System.out.println("Duplicate ID provided. Must be a new ID");
		System.out.println("\n\nTry again!");
	}
}

class departmentInputException extends Exception {
	public void printMessage() {
		System.out.println("Invalid department input. Must be mathematics, engineering, or english");
		System.out.println("\n\nTry again!");
	}
}

class rankInputException extends Exception {
	public void printMessage() {
		System.out.println("Invalid rank input. Must be professor or adjunct");
		System.out.println("\n\nTry again!");
	}
}

class noFacultyFoundException extends Exception {
	public void printMessage() {
		System.out.print("Sorry no faculty with ID = ");
	}
}

class statusInputException extends Exception {
	public void printMessage() {
		System.out.println("Invalid rank input. Must be part-time or full-time");
		System.out.println("\n\nTry again!");
	}
}

class noStaffFoundException extends Exception {
	public void printMessage() {
		System.out.print("Sorry no staff with ID = ");
	}
}

class noPersonFoundException extends Exception {
	public void printMessage() {
		System.out.print("Sorry no person with ID = ");
	}
}
