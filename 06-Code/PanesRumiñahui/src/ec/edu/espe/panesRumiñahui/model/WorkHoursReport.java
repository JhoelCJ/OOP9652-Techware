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
        
        boolean finishMenu = true;
        
        while (finishMenu) {
            System.out.println("\n1. Registrar la hora de entrada");
            System.out.println("2. Registrar la hora de salida");
            System.out.println("3. Atras");
            System.out.print("\n\tElija una opcion: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("\nIngrese su nombre: ");
                    String name = scanner.nextLine();
                    LocalDateTime entryTime = LocalDateTime.now();
                    workHours.put(name, entryTime);
                    System.out.println("\nHora de entrada registrada por " + name + " a las " + entryTime.format(formatter));
                    break;
                    
                case 2:
                    System.out.print("\nIngrese su nombre: ");
                    name = scanner.nextLine();
                    LocalDateTime exitTime = LocalDateTime.now();
                    LocalDateTime storedEntryTime = workHours.get(name);
                    if (storedEntryTime != null) {
                        long hoursWorked = storedEntryTime.until(exitTime, java.time.temporal.ChronoUnit.HOURS);
                        System.out.println("\nHora de entrada registrada por " + name + " a las " + exitTime.format(formatter));
                        System.out.println("\n\tTotal Horas de Trabajo: " + hoursWorked);
                        workHours.remove(name); // Remove the entry for the user
                    } else {
                        System.out.println("\nNo hay horas registradas por " + name);
                    }
                    break;
                    
                case 3:
                    finishMenu = false;
                    
                default:
                    System.out.println("Opcion Invalida, Por favor ingrese de nuevo.");
                    break;
            }
            
            System.out.println(); // Print a blank line for readability
        }
    }
}
