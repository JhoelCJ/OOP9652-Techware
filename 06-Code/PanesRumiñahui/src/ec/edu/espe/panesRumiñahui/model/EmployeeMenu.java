package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Calderón Jilmar, Techware, DCCO-ESPE
 */

public class EmployeeMenu {
    
    public void employeeMenu() throws FileNotFoundException{
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int option;
          
        do {
            System.out.println("1. Enter entry time");
            System.out.println("2. View inventory");
            System.out.println("3. Modify inventory");
            System.out.println("4. Register Sales");
            System.out.println("5. Enter Extit time");
            System.out.println("6. Exit");
            System.out.print("Enter the option: ");
            option = scanner.nextInt();
            
            switch (option) {
        
                case 1:
            
                    break;
                case 2:
                    inventory.readInventory();
                    break;
                case 3:
                    inventory.writeInventoryProduct();
                    inventory.writeInventoryRawMaterial();
                    break;
                case 4:
            
                    break;
                case 5:
            
                    break;
                case 6:
            
                    break;
                default:
                    System.out.println("Invalid Option, please select number again between 1 and 6");
            }
        }while(option< 1 || option >6);
    }
    
}
