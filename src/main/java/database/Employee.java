package database;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Employee 
{
	private int id;
	@NotEmpty(message = "Name cannot be null")
	private String name;
	private int salary;
	//@Pattern(regexp = "^[A].+")
	@Size(min = 1, max = 5, message = "must be between 1 and 5 characters")
	private String password;
	@Email(message = "Email should be valid")
	private String email;
	
	public Employee() {}
	
	public Employee(int id, String name, int salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString(){  
	    return id+" "+name+" "+salary;  
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}  
}
