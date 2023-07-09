

package ec.edu.espe.panesdelaruminahui.view;

import ec.edu.espe.panesdelaruminahui.controler.AdministradorConectDB;
import java.util.Scanner;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class Menu {

    public static void main(String[] args) {
        int option;
        boolean exitMenu = false;
        Scanner sc = new Scanner(System.in);

        try {
            while (!exitMenu) {
                System.out.println("\n1. Insert new Adiministrador");
                System.out.println("2. Find a Administrador");
                System.out.println("3. Modify a Administrador");
                System.out.println("4. Delete a Administrador");
                System.out.println("5. Show everything Administrador");
                System.out.println("6. Exit");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        AdministradorConectDB.createDocument();
                        break;
                    case 2:
                        AdministradorConectDB.readDocument();
                        break;
                    case 3:
                        AdministradorConectDB.modifyDocument();
                        break;
                    case 4:
                        AdministradorConectDB.deleteDocument();
                        break;
                    case 5:
                        AdministradorConectDB.showDatabase();
                        break;
                    case 6:
                        exitMenu = true;
                        break;
                    default:
                        System.out.println("Please enter values from 1 to 5");
                        option = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect Value");
        }

    }
}
