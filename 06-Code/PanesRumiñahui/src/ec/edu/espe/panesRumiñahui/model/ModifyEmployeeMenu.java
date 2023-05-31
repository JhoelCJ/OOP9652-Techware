package ec.edu.espe.panesrumiñahui.model;

import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class ModifyEmployeeMenu {
    public void modifyEmployeeMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;
            
        do {
            
            ModifyEmployee modifyEmployee = new ModifyEmployee();
            
            System.out.println ("1. Add employee");
            System.out.println ("2. Edit employee");
            System.out.println ("3. Delete employee");
            System.out.println ("4. Exit");
            System.out.print("Enter the option: ");
            option = scanner.nextInt();
            
            switch (option) {
                
                case 1:
                    modifyEmployee.createEmployee();
                    break;
                case 2:
                    modifyEmployee.editEmployee();
                    break;
                case 3:
                    modifyEmployee.deleteEmployee();
                    break;
                default:
                    System.out.println("Invalid Option, please select number again between 1 and 4");
            }
        }while(option< 1 || option >3);
    }
}
