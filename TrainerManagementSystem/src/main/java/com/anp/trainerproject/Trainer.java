package com.anp.trainerproject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {       // Entity class Trainer 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;     // Unique identifier for the trainer
	private String firstName;  // First name of the trainer
	private String lastName;   // Last name of the trainer
	private double salary;     // Salary of the trainer
	private String email;      // Email address of the trainer
	private String gender;
	
	// Getters and setters for the Trainer properties
	public int getId() {
		return trainerId;
	}
	public void setId(int id) {
		this.trainerId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	// Overridden toString() method to provide a string representation of the Trainer object
	
	@Override
	public String toString() {
		return "Trainer [id=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", email=" + email + ", gender=" + gender + "]";
	}
	// Constructors for the Trainer class
	public Trainer(int trainerId, String firstName, String lastName, double salary, String email, String gender) {
		super();
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.gender = gender;
	}
	public Trainer() {
		super();
	}
}