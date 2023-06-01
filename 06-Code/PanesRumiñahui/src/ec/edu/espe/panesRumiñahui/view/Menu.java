package ec.edu.espe.panesrumiñahui.view;

import ec.edu.espe.panesrumiñahui.model.Administrator;
import ec.edu.espe.panesrumiñahui.model.AdministratorMenu;
import ec.edu.espe.panesrumiñahui.model.Employee;
import ec.edu.espe.panesrumiñahui.model.EmployeeMenu;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Menu {
    private ArrayList<Employee> employee;
    private ArrayList<Administrator> administrator;

    public void showMenu() throws FileNotFoundException {
        employee = new ArrayList<>();
        administrator = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        AdministratorMenu administratorMenu = new AdministratorMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        int option;
        int choise;

        System.out.println("------ Bienvenido a Panes de la Rumiñahui ------");
        System.out.println("--- System by Techware ---");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado ");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    administratorMenu.administratorMenu();
                    break;
                case 2:
                    employeeMenu.employeeMenu();
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo: ");
            }
        } while (option != 3);
    }
}
