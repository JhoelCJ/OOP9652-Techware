package ec.edu.espe.panesrumiñahui.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class WorkHoursReport {
    
    public void workHour(){
    
        Map<String, LocalDateTime> workHours = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        while (true) {
            System.out.println("1. Register entry work hour");
            System.out.println("2. Register exit work hour");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    LocalDateTime entryTime = LocalDateTime.now();
                    workHours.put(name, entryTime);
                    System.out.println("Entry work hour registered for " + name + " at " + entryTime.format(formatter));
                    break;
                    
                case 2:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    LocalDateTime exitTime = LocalDateTime.now();
                    LocalDateTime storedEntryTime = workHours.get(name);
                    if (storedEntryTime != null) {
                        long hoursWorked = storedEntryTime.until(exitTime, java.time.temporal.ChronoUnit.HOURS);
                        System.out.println("Exit work hour registered for " + name + " at " + exitTime.format(formatter));
                        System.out.println("Total hours worked: " + hoursWorked);
                        workHours.remove(name); // Remove the entry for the user
                    } else {
                        System.out.println("No entry work hour found for " + name);
                    }
                    break;
                    
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println(); // Print a blank line for readability
        }
    }
}
