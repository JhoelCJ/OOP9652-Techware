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
    
    public void workHour() {
        ValidationUtil validationUtil = new ValidationUtil();
        Map<String, LocalDateTime> workHours = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        boolean continueMenu = true;
        
        while (continueMenu) {
            System.out.println("\n1. Registrar hora de ingreso");
            System.out.println("2. Registrar hora de salida");
            System.out.println("3. Salir");
            System.out.print("\n\tIngrese opcion: ");
            String choice = scanner.nextLine();
            if (validationUtil.validateInt(choice)) {
                switch (validationUtil.getInt(choice)) {
                    case 1:
                        String name = null;
                        boolean continueValidation = true;
                        while (continueValidation) {
                            System.out.print("Nombre: ");
                            name = scanner.nextLine();
                            if (validationUtil.ValidateLetterString(name)) {
                                continueValidation = false;
                            } else {
                                System.out.println("Dato Invalido");
                            }
                        }
                        LocalDateTime entryTime = LocalDateTime.now();
                        workHours.put(name, entryTime);
                        System.out.println("Entry work hour registered for " + name + " at " + entryTime.format(formatter));
                        break;
                    
                    case 2:
                        name = null;
                        continueValidation = true;
                        while (continueValidation) {
                            System.out.print("Nombre: ");
                            name = scanner.nextLine();
                            if (validationUtil.ValidateLetterString(name)) {
                                continueValidation = false;
                            } else {
                                System.out.println("Dato Invalido");
                            }
                        }
                        LocalDateTime exitTime = LocalDateTime.now();
                        LocalDateTime storedEntryTime = workHours.get(name);
                        if (storedEntryTime != null) {
                            long hoursWorked = storedEntryTime.until(exitTime, java.time.temporal.ChronoUnit.HOURS);
                            System.out.println("Exit work hour registered for " + name + " at " + exitTime.format(formatter));
                            System.out.println("Total hours worked: " + hoursWorked);
                            workHours.remove(name);
                        } else {
                            System.out.println("No entry work hour found for " + name);
                        }
                        break;
                    
                    case 3:
                        continueMenu = false;
                        break;
                    
                    default:
                        System.out.println("Dato invalido.");
                        break;
                }
            }else{
                System.out.println("\nDato Inalido!!");
            }
            System.out.println();
        }
    }
}
