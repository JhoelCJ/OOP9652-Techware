package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditSaleData;
import ec.edu.espe.panesrumiñahui.model.Sale;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class SaleOperation {

    public void saleWriter()throws FileNotFoundException {

        EditSaleData editSaleData = new EditSaleData();
        ArrayList<Sale> listSale= new ArrayList<>();
        Sale sale;
        Scanner scanner = new Scanner(System.in);

        double totalSales = 0;
        float saleOperation;

        System.out.print("Ingrese el número de ventas realizadas: ");
        saleOperation = scanner.nextInt();

        for (int i = 1; i <= saleOperation; i++) {
            System.out.print("Ingrese el monto de la venta " + i + ": ");
            double montoVenta = scanner.nextDouble();
            totalSales += montoVenta;
        }

        System.out.println("El total de ventas realizadas es: " + totalSales);
        
        sale = new Sale(totalSales);

        File archivo = new File("sale.json");
        if (archivo.exists() && archivo.length() == 0) {
            listSale = new ArrayList<>();
        } else {
            listSale = editSaleData.readSaleData();
        }

        listSale.add(sale);
        editSaleData.writeSaleData(listSale);

    }   // scanner.close(); 

    public void readSale() throws FileNotFoundException {
        EditSaleData editSaleData = new EditSaleData();
        File archivo = new File("sale.json");
        ArrayList<Sale> listSale = new ArrayList<>();
        System.out.println("\t\t\t\tSale List");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay ventas\n\n");
        } else {
            listSale = editSaleData.readSaleData();
            int i=1;
            for (Sale sale : listSale) {
                System.out.println("Venta total del dia "+i+": "+sale.getTotalSales());
                i=i+1;
            }
        }
    }
}
