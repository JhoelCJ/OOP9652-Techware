package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyInventoryMenu {
    public void modifyInventoryMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int option;
            
        do {
            ModifyProduct modifyProduct = new ModifyProduct();
            ModifyRawMaterial modifyRawMaterial = new ModifyRawMaterial();
            
            System.out.println ("\n1. Agregar Nuevo Producto");
            System.out.println ("2. Agregar Productos en stock");
            System.out.println ("3. Agregar Nueva materia prima");
            System.out.println ("4. Agregar Materia prima en stock");
            System.out.println ("5. Salir");
            System.out.print("\n\tIngrece una opcion: ");
            option = scanner.nextInt();
            
            switch (option) {
                
                case 1:
                    modifyProduct.createProduct();
                    break;
                case 2:
                    modifyProduct.addProductStock();
                    break;
                case 3:
                    modifyRawMaterial.createRawMaterial();
                    break;
                case 4:
                    modifyRawMaterial.addProductStock();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 3");
            }
        }while(option< 1 || option >5);
    }
}
