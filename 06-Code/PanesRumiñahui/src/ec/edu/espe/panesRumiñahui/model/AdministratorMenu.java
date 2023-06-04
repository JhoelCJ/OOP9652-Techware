package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *@author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class AdministratorMenu {
    
    public void administratorMenu() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        int option;
            
        do {
            
            ModifyEmployee modifyEmployee = new ModifyEmployee();
            ModifyEmployeeMenu modifyEmployeeMenu = new ModifyEmployeeMenu();
            Inventory inventory = new Inventory();
            
            System.out.println ("\n1. Ver empleado: ");
            System.out.println ("2. Modificar empleado: ");
            System.out.println ("3. Ver inventario: ");
            System.out.println ("4. Modificar inventario: ");
            System.out.println ("5. Añadir administrador: ");
            System.out.println ("6. Ver administrador: ");
            System.out.println ("7. Salir");
            System.out.print("\n\tIngrese una opcion: ");
            option = scanner.nextInt();
            
            switch (option) {
                
                case 1:
                    modifyEmployee.readEmployee();
                    break;
                case 2:
                    modifyEmployeeMenu.modifyEmployeeMenu();
                    break;
                case 3:
                    inventory.readInventory();
                    break;
                case 4:
                    inventory.writeInventory();
                    break;
                case 5:
            
                    break;
                case 6:
            
                    break;
                case 7:
            
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 7");
            }
        }while(option< 1 || option >7);
    }
}
