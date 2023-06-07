package ec.edu.espe.view.panesRumiñahui;

import ec.edu.espe.panesrumiñahui.model.AdministratorMenu;
import ec.edu.espe.panesrumiñahui.model.EmployeeMenu;
import ec.edu.espe.panesrumiñahui.model.ValidationUtil;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class Menu {

    public void showMenu() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        AdministratorMenu administratorMenu = new AdministratorMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        ValidationUtil validationUtil = new ValidationUtil();

        System.out.println("\n\t\t------ Bienvenido a Panes de la Ruminiahui ------");
        System.out.println("\n\t\t\t---- System by Techware ----");

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("\nMenu:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado ");
            System.out.println("3. Salir");
            System.out.print("\n\tIngrese una opcion: ");

            String choise = scanner.nextLine();

            if (validationUtil.validateInt(choise)) {
                
                switch (validationUtil.getInt(choise)) {
                    case 1: 
                        try {
                        administratorMenu.administratorMenu();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                    case 2:
                        employeeMenu.employeeMenu();
                        break;

                    case 3:
                        System.out.println("\nGracias por usar el programa\n\n");
                        continueMenu = false;
                        break;

                    default:
                        System.out.println("Opcion invalida, intente de nuevo: ");
                }
            } else {
                System.out.println("\nDato Invalido!!");
            }
        }
    }
}
