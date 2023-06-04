package ec.edu.espe.panesrumiñahui.model;

import java.util.Scanner;

/**
 *@author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class EmployeeMenu {
    
    public void employeeMenu(){
        
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Sale sale = new Sale();
        WorkHoursReport workHoursReport = new WorkHoursReport();
        int option;
          
        do {
            
            System.out.println("\n1. Ingrese la hora de entrada/salida: ");
            System.out.println("2. Ver inventario: ");
            System.out.println("3. Modificar inventario: ");
            System.out.println("4. Registrar ventas: ");
            System.out.println("5. Mostrar Ventas: ");
            System.out.println("6. Salir: ");
            System.out.print("\n\tIngrese una opcion: ");
            option = scanner.nextInt();
            
            switch (option) {
        
                case 1:
                    workHoursReport.workHour();
                    break;
                case 2:
                    inventory.readInventory();//Llamar al inventario
                    break;
                case 3:
                    inventory.writeInventory();//Modificar el inventario
                    break;
                case 4:
                    sale.sale();//LLmar a la clase que registre las ventas realizadas en el dia
                    break;
                case 5:
                    //sale.readSale();
                    break;
                case 6:
            
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 6");
            }
        }while(option< 1 || option >6);
    }
    
}
