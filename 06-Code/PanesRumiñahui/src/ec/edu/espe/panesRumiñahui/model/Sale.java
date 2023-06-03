package ec.edu.espe.Sales.model;

import java.util.Scanner;
/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Sale {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double totalSales = 0;
        int sale;
        
        System.out.print("Ingrese el número de ventas realizadas: ");
        sale = scanner.nextInt();

        for (int i = 1; i <= sale; i++) {
            System.out.print("Ingrese el monto de la venta " + i + ": ");
            double montoVenta = scanner.nextDouble();
            totalSales += montoVenta;
        }
        
        System.out.println("El total de ventas realizadas es: " + totalSales);
       
        scanner.close();
    }
}
