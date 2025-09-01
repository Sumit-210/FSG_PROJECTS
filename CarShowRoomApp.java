package org.fsg.map.project;

import java.util.*;

public class CarShowRoomApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        List<Map<String, Object>> map = new ArrayList<>();

      
        CarService carService = new CarServiceImpl(map, scanner);

        while (true) {
            System.out.println("1. Add Car\n2. Remove Car\n3. Update Car\n4. View Car\n5. Sort Car\n6. Exit");
            System.out.println("Enter your choice:");

            int ch = scanner.nextInt();

            switch (ch) {
                case 1: 
                    carService.addCar();
                    break;
                case 2: 
                    carService.removeCar();
                    break;
                case 3: 
                    carService.updateCar();
                    break;
                case 4: 
                    carService.viewCar();
                    break;
                case 5: 
                    carService.sortCar();
                    break;
                case 6: 
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
