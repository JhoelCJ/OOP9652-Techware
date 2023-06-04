package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditInventoryData;
import ec.edu.espe.panesrumiñahui.controller.EditSaleData;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Sale {
    public void sale(){
        
        Scanner scanner = new Scanner(System.in);

        double totalSales = 0;
        float sale;
        
        System.out.print("\nIngrese el número de ventas realizadas: ");
        sale = scanner.nextInt();

        for (int i = 1; i <= sale; i++) {
            System.out.print("\nIngrese el monto de la venta " + i + ": ");
            double montoVenta = scanner.nextDouble();
            totalSales += montoVenta;
        }
        
        System.out.println("\nEl total de ventas realizadas es: " + totalSales);
       
    }   // scanner.close();

}