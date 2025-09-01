package org.fsg.map.project;

import java.util.*;


public class CarServiceImpl implements CarService {

    List<Map<String, Object>> map;
    Scanner scanner;

    public CarServiceImpl(List<Map<String, Object>> map, Scanner scanner) {
        super();
        this.map = map;
        this.scanner = scanner;
    }

    @Override
    public void addCar() {
      Map<String,Object> car = readCarDetails();
      map.add(car);
    }

    @Override
    public void removeCar() {
        System.out.println("Enter Car Number to remove:");
        String num = scanner.next();

        Map<String, Object> carToRemove = null;

        for (Map<String, Object> car : map) {
            if (car.get("num").equals(num)) {
                carToRemove = car; 
                break;
            }
        }

        if (carToRemove != null) {
            map.remove(carToRemove);
            System.out.println("Car removed successfully!");
        } else {
            System.out.println("Car with number " + num + " not found!");
        }
    }



 
  
    	@Override
    	public void viewCar() {
    	    if (map.isEmpty()) {
    	        System.out.println("No cars to display");
    	    } else {
    	        System.out.println("---- Car Details ----");
    	        for (Map<String, Object> car : map) {
    	            for (Map.Entry<String, Object> e : car.entrySet()) {
    	                System.out.println(e.getKey() + " : " + e.getValue());
    	            }
    	            System.out.println("---------------------");
    	        }
    	    }
    	

    }

    	@Override
    	public void updateCar() {
    	    if (map.isEmpty()) {
    	        System.out.println("No cars available to update");
    	        return;
    	    }

    	    scanner.nextLine();
    	    System.out.println("Enter the car number you want to update:");
    	    String number = scanner.nextLine();

    	    for (Map<String, Object> m : map) {
    	        if (m.containsValue(number)) {
    	            System.out.println("Select the field you want to update");
    	            System.out.println("1. Price\n2.Color\n");
    	            int choice = scanner.nextInt();
    	            scanner.nextLine(); 

    	            switch (choice) {
    	                

    	                case 1:
    	                    System.out.println("Enter the new price:");
    	                    Double price = scanner.nextDouble();
    	                    m.put("price", price);
    	                    break;

    	                case 2:
    	                    System.out.println("Enter the new color:");
    	                    String color = scanner.nextLine();
    	                    m.put("color", color);
    	                    break;

    	                

    	                
    	                default:
    	                    System.out.println("Invalid choice");
    	                    return;
    	            }
    	            System.out.println("Car details updated successfully!");
    	            return;
    	        }
    	    }

    	    System.out.println("Car with number " + number + " not found.");
    	}


    @Override
	public void sortCar() {
	    if (map.isEmpty()) {
	        System.out.println("No cars available to sort!");
	        return;
	    }
	    System.out.println("1.Number\n2.Price\n3.Color");
	    System.out.println("Enter the choice");
	    int ch=scanner.nextInt();
	
	    switch(ch)
	    {
	    case 1: Collections.sort(map, new Comparator<Map<String, Object>>() {
	                @Override
	                public int compare(Map<String, Object> c1, Map<String, Object> c2) {
	                    return c1.get("num").toString().compareTo(c2.get("num").toString());
	                }
	            });
	    case 2:Collections.sort(map, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> c1, Map<String, Object> c2) {
                return c1.get("price").toString().compareTo(c2.get("price").toString());
            }
        });
	    case 3:Collections.sort(map, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> c1, Map<String, Object> c2) {
                return c1.get("color").toString().compareTo(c2.get("color").toString());
            }
        });
	            
	    }    
	    
	    System.out.println("cars after sorting");
	    viewCar();
	       
    }
    
    private Map<String, Object> readCarDetails() {
        System.out.println("Enter the car number");
        String num = scanner.next();

        System.out.println("Enter the car name");
        String name = scanner.next();

        System.out.println("Enter the car color");
        String color = scanner.next();

        System.out.println("Enter the car brand");
        String brand = scanner.next();

        System.out.println("Enter the car YOM");
        int yom = scanner.nextInt();

        System.out.println("Enter the car price");
        double price = scanner.nextDouble();

        Map<String, Object> car = new LinkedHashMap<String, Object>();
        car.put("num", num);
        car.put("name", name);
        car.put("color", color);
        car.put("brand", brand);
        car.put("yom", yom);
        car.put("price", price);

        return car;
    }

}
