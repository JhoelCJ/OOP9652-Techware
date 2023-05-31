
package ec.edu.espe.chickenfarm.model;

import java.util.Scanner;

/**
 *
 * @author Techware, DCCO-ESPE
 */
public class EmployeeMenu{
    
    Scanner scanner = new Scanner(System.in);
    
    int option;
    
    System.out.println("1. Enter entry time");
    System.out.println("2. View inventory");
    System.out.println("3. Modify inventory");
    System.out.println("4. Register Sales");
    System.out.println("5. Enter Extit time");
    System.out.println("6. Extit");
          
        do {
            option = scanner.nextInt();
        if (Option < 1 || option > 6){
            System.out.println("Invalid Option, please select number again between 1 and 7");
        }

    }while(option < 1 || option > 6);
    
            
    switch (option){
        
        case 1:
            
            break;
        case 2:
            
            break;

        case 3:
            
            break;

        case 4:
            
            break;
        case 5:
            
            break;
        case 6:
            
            break;

        default:
            System.out.println("Invalid option, enter again: ");
    }   
}
