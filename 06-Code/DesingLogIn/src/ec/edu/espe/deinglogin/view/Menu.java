
package ec.edu.espe.deinglogin.view;

import ec.edu.espe.deinglogin.model.Login;
import java.util.Scanner;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class Menu {
    
    public static void main(String[] args) {
        int option;
        boolean exitmenu = false;
        Scanner sc = new Scanner(System.in);
        try {
            while(!exitmenu){
                System.out.println("\n1. Insert username/password");
                System.out.println("2. Show all Username");
                System.out.println("3. Comprobation username/password");
                System.out.println("4. Exit");
                System.out.println("Selected Option");
                option = sc.nextInt();
                
                switch(option)
                {
                    case 1:   
                    Login.createDocument();
                    break;
                    case 2:
                    Login.showDatabase();
                    break;
                    case 3:
                    Login.deleteDocument();
                    break;
                    case 4:
                        exitmenu = true;
                        break;
                    default:
                        System.out.println("Please enter values from 1 to 3");
                        option = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect Value");
        }
        
    }
    
}
