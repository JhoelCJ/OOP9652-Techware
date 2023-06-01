package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
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
            
            System.out.println ("1. View employee");
            System.out.println ("2. Modify employee");
            System.out.println ("3. View inventory");
            System.out.println ("4. Modify inventory");
            System.out.println ("5. Add Administrator");
            System.out.println ("6. View Administrator");
            System.out.println ("7. Exit");
            System.out.print("Enter the option: ");
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
                    System.out.println("Invalid Option, please select number again between 1 and 7");
            }
        }while(option< 1 || option >7);
    }
}
