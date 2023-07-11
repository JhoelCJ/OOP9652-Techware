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
            while (!exitmenu) {
                System.out.println("\n1. Inserte username/password");
                System.out.println("2. Muestre todos los username");
                System.out.println("3. Comprobacion username/password");
                System.out.println("4. Salir");
                System.out.println("Seleccione una opcion");
                option = sc.nextInt();

                switch (option) {
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
                        System.out.println("Ingrese un valor del 1 al 4");
                        option = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Valor incorrecto");
        }
    }
}
