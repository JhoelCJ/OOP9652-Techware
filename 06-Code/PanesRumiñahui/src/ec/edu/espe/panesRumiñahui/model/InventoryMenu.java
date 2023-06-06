package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class InventoryMenu {
    public void inventoryMenu() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        boolean continueMenu = true;
        
        while(continueMenu){
            Inventory inventory = new Inventory();
            
            System.out.println ("\n1. Ventas del dia: ");
            System.out.println ("2. Total de ventas Diaria: ");
            System.out.println ("3. Productos en stock: ");
            System.out.println ("4. Materia prima en stock: ");
            System.out.println ("5. Salir");
            System.out.print("\n\tIngrese una opcion: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    inventory.dailySale();
                    break;
                case 2:
                    System.out.println("Venta total del dia: " + inventory.totalDailySale() + "\n");
                    break;
                case 3:
                    inventory.productStock();
                    break;
                case 4:
                    inventory.rawMaterialStock();
                    break;
                case 5:
                    continueMenu = false;
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 7");
            }
        }
    }
}
