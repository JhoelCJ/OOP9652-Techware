package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EmployeeMenu {

    public void employeeMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        SaleOperation saleOperation = new SaleOperation();
        InventoryMenu inventoryMenu = new InventoryMenu();
        WorkHoursReport workHoursReport = new WorkHoursReport();
        ModifyInventoryMenu modifyInventoryMenu = new ModifyInventoryMenu();
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
                    inventoryMenu.inventoryMenu();
                    break;
                case 3:
                    modifyInventoryMenu.modifyInventoryMenu();
                    break;
                case 4:
                    saleOperation.saleWriter();
                    break;
                case 5:
                    saleOperation.readSale();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 6");
            }
        } while (option < 1 || option > 6);
    }
}
