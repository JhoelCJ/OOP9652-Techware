package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *@author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class ModifyEmployeeMenu {
    public void modifyEmployeeMenu() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        int option;
            
        do {
            
            ModifyEmployee modifyEmployee = new ModifyEmployee();
            
            System.out.println ("\n1. Agregar Empleado");
            System.out.println ("2. Elimiar ");
            System.out.println ("3. Saalir");
            System.out.print("\n\tIngrece una opcion: ");
            option = scanner.nextInt();
            
            switch (option) {
                
                case 1:
                    modifyEmployee.createEmployee();
                    break;
                case 2:
                    modifyEmployee.deleteEmployee();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 3");
            }
        }while(option< 1 || option >2);
    }
}
