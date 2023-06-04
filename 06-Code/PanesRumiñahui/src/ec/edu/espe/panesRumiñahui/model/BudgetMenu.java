
package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.model.Inventory;
import java.util.Scanner;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class BudgetMenu {
    
    public void budgetMenu(){
        
        Scanner scanner = new Scanner(System.in);
        
        int option;
          
        do {
            
            System.out.println("1. Ingrese El presupuesto del Mes: ");
            System.out.println("2. Ver dinero disponible: ");
            System.out.println("3. Pago a los empleados: ");
            System.out.println("4. Gastos de compras: ");
            System.out.println("5. Pago a impuestos: ");
            System.out.println("6. Salir: ");
            System.out.print("Ingrese una opcion: ");
            option = scanner.nextInt();
            
            switch (option) {
        
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
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 6");
            }
        }while(option< 1 || option >6);
    }
    
}
