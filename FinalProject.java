/*
- Final Project
- AJ Romaniello and Clayton Monfils
- (Optional) Any other notes for the TA
*/

//testing here

public class FinalProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Person{
	private String fullName;
	private String id;
	
	public Person(String fullname, String id) {
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
		//need to complete this
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
		//need to complete this
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
		//need to complete this
	}
}
