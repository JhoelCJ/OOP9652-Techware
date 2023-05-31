package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.controller.JsonGenerator;
import ec.edu.espe.chickenfarm.model.Administrator;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Techware, DCCO-ESPE
 */

public class Menu {
    private ArrayList<Employee> employee;
    private ArrayList<Administrator> administrator;

    public void showMenu() {
        employee = new ArrayList<>();
        administrator = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Wlcome to Panes de la Rumiñahui ------");
        
        System.out.println("--- System by Techware ---");

        int option;
        int choise;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Administrator");
            System.out.println("2. Employee ");
            System.out.println("3. Exit");
            System.out.print("Enter the option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;

                default:
                    System.out.println("Invalid option, enter again: ");
            }
        } while (option != 3);
    }
}
