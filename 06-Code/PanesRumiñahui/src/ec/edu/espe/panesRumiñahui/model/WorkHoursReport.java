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

        Map<String, LocalDateTime> workHours = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        ValidationUtil validationUtil = new ValidationUtil();
        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("\n1. Registrar hora de ingreso");
            System.out.println("2. Registrar hora de salida");
            System.out.println("3. Salir");
            System.out.print("\n\tEnter your choice: ");

            String choice = scanner.next();

            scanner.nextLine();

            if (validationUtil.validateInt(choice)) {
                switch (validationUtil.getInt(choice)) {

                    case 1:

                        System.out.print("Ingrese su Nombre: ");
                        String name = scanner.nextLine();
                        while (!validationUtil.ValidateLetterString(name)) {
                            System.out.println("\nEl nombre debe contener letras.");
                            System.out.print("Nombre: ");
                            name = scanner.nextLine();
                        }
                        LocalDateTime entryTime = LocalDateTime.now();
                        workHours.put(name, entryTime);
                        System.out.println("\nHora de entrada registrada por " + name + " a las " + entryTime.format(formatter));

                        break;

                    case 2:

                        System.out.print("Ingrese su Nombre: ");
                        name = scanner.nextLine();
                        while (!validationUtil.ValidateLetterString(name)) {
                            System.out.println("\nEl nombre debe contener letras.");
                            System.out.print("Nombre: ");
                            name = scanner.nextLine();
                        }
                        LocalDateTime exitTime = LocalDateTime.now();
                        LocalDateTime storedEntryTime = workHours.get(name);
                        if (storedEntryTime != null) {
                            long hoursWorked = storedEntryTime.until(exitTime, java.time.temporal.ChronoUnit.HOURS);
                            System.out.println("\nHora de entrada registrada por " + name + " a las " + exitTime.format(formatter));
                            System.out.println("\n\tTotal Horas de Trabajo: " + hoursWorked);
                            workHours.remove(name);
                        } else {
                            System.out.println("\nNo hay horas registradas por " + name);
                        }
                        break;

                    case 3:
                        continueMenu = false;
                        break;

                    default:
                        System.out.println("Opcion Invalida, Por favor ingrese de nuevo.");
                        break;

                }

            } else {
                System.out.println("\nDato Invalido!!");

            }
        }
    }
}
