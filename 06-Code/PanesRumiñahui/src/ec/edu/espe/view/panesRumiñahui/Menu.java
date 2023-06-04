package ec.edu.espe.view.panesRumiñahui;

import ec.edu.espe.panesRumiñahui.model.BudgetMenu;
import ec.edu.espe.panesrumiñahui.model.Administrator;
import ec.edu.espe.panesrumiñahui.model.AdministratorMenu;
import ec.edu.espe.panesrumiñahui.model.Employee;
import ec.edu.espe.panesrumiñahui.model.EmployeeMenu;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Menu {
    private ArrayList<Employee> employee;
    private ArrayList<Administrator> administrator;

    public void showMenu(){ /*throws FileNotFoundException*/ 
        
        employee = new ArrayList<>();
        administrator = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        AdministratorMenu administratorMenu = new AdministratorMenu();
        EmployeeMenu employeeMenu = new EmployeeMenu();
        BudgetMenu budgetMenu= new BudgetMenu();
        
        //int option;
        int choise;

        System.out.println("------ Bienvenido a Panes de la Rumiñahui ------");
        System.out.println("--- System by Techware ---");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado ");
            System.out.println("3. Presupuesto ");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            choise = scanner.nextInt();

            switch (choise) {
                case 1:
                {
                    try {
                        administratorMenu.administratorMenu();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case 2:
                    employeeMenu.employeeMenu();
                    break;
                case 3:
                    budgetMenu.budgetMenu();
                    break;
                 case 4:
                     System.out.println("Gracias por usar el programa");
                    break;   
                /*default:
                    System.out.println("Opcion invalida, intente de nuevo: ");
            */}
        } while (choise != 4);
    }
}
