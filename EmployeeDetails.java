package org.fsg.collection.project;

import java.util.*;

public class EmployeeDetails implements CommonDetails,Comparator<Employee> {
	
	private List<Employee> employees;
	private Scanner scanner;
	
	
	public EmployeeDetails(List<Employee> employees, Scanner scanner) {	
		this.employees = employees;
		this.scanner = scanner;
	}
@Override
	public void add() {
		Employee e = readEmployeeDetails();
		if(Objects.nonNull(e))
			employees.add(e);
	}
	
	private Employee readEmployeeDetails() {
		System.out.println("Enter the employee id");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the employee name");
		String name = scanner.nextLine();
		
		System.out.println("Enter the employee salary");
		double salary = scanner.nextDouble();
		
		System.out.println("Enter the employee mobile number");
		long mobile = scanner.nextLong();
		
		System.out.println("Enter the empployee email");
		String email = scanner.next();
		
		//check if email is valid
		if(!email.contains("@")) {
			System.out.println("Invalid Email, Idiot enter proper email id");
			return null;
		}			
		
		return new Employee(id, name, salary, mobile, email);
	}
	@Override
	public void remove() {
	    System.out.println("Enter the employee ID to remove:");
	    int id = scanner.nextInt();

	    Employee empToRemove = null;
	    for (Employee e : employees) {
	        if (e.getId() == id) {
	            empToRemove = e;
	        }
	    }

	    if (empToRemove != null) {
	        employees.remove(empToRemove);
	        System.out.println("Removerd the Employee with the ID ."+id);
	    } 
	    else {
	    	try {
				throw new InvalidIdException("ID "+id+" not found");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
	    }
	}
	@Override
	public void display() {
		System.out.println("id+\tname\tsalary\tmobile\temail");
		System.out.println("-------------------------------------------------");
		
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
	@Override
	public void sort() {
		    System.out.println("Choose sorting order:");
		    System.out.println("1. Ascending\n 2. Descending");
		   
		    sortOrder = scanner.nextInt();
		    System.out.println("Choose sorting criteria:");
		    System.out.println("1. ID \n2. Name \n3. Salary");
		  
		    sortCriteria = scanner.nextInt();
		    employees.sort(this);
		    System.out.println("Employees after sorting:");
		    display();
		    
	}
	@Override	
	public void update() {
	    System.out.println("1.Mobile\n2.Email");
	    System.out.println("Enter your choice");
	    int ch = scanner.nextInt();
 
	    if (ch == 1) {	    	
	    	System.out.println("Enter employee ID to be updated:");
	 	    int id = scanner.nextInt();

	 	    for (Employee e : employees) {
	 	        if (e.getId() == id) {
	 
	 	           System.out.println("Enter new mobile number:");
	 		        long newMobile = scanner.nextLong();
	 		        e.setMobile(newMobile);
	 		       System.out.println("Mobile number updated successfully.");
	 		        return;
	 	        }
	 	        
	 	        
	 	    }
	 	    try {
				throw new InvalidIdException("ID "+id+" not found");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}

	      
	    }
	    
	    
	    else if (ch == 2) {
	    	 System.out.println("Enter employee ID to be updated:");
	 	    int id = scanner.nextInt();

	 	    for (Employee e : employees) {
	 	        if (e.getId() == id) {
	 	        	  System.out.println("Enter new email:");
	 	 	        String newEmail = scanner.next();
	 	 	      e.setEmail(newEmail);
	 	 	       System.out.println("Email id updated successfully");
	 	 	     return;
	 	           
	 	        }
	 	        
	 	    }

	 	   try {
				throw new InvalidIdException("ID "+id+" not found");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}     
	 	    }
   
	    else {
	        System.out.println("Invalid choice");
	    }

	}
	private int sortOrder ;
	 private int sortCriteria ;
	 @Override
	 public int compare(Employee o1, Employee o2) {
		    int result = 0;

		    switch (sortCriteria) {
		        case 1:
		            result = Integer.compare(o1.getId(), o2.getId());
		            break;
		        case 2:
		            result = o1.getName().compareTo(o2.getName());
		            break;
		        case 3:
		            result = Double.compare(o1.getSalary(), o2.getSalary());
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid sorting criteria");
		    }

		    if (sortOrder == 2) {
		        result = -result;
		    }

		    return result;
		}

}