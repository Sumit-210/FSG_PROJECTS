package org.fsg.collection.project;

public class Employee {
	private Integer id;
	private String name;
	private Double salary;
	private long mobile;
	private String email;
	
	
	public Employee(Integer id, String name, Double salary, long mobile, String email) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.mobile = mobile;
		this.email = email;
	}
	public Employee() {
		//dummy
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return id+"\t"+name+"\t"+salary+"\t"+mobile+"\t"+email;
	}
	
	
	
	
}
  