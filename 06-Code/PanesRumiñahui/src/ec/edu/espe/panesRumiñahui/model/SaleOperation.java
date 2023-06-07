package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditProductData;
import ec.edu.espe.panesrumiñahui.controller.EditSaleData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class SaleOperation {

    public void saleWriter() throws FileNotFoundException {

        EditProductData editProductData = new EditProductData();
        ArrayList<Product> listProduct = new ArrayList();
        File fileProduct = new File("data\\product.json");

        if (fileProduct.exists() && fileProduct.length() == 0) {
            System.out.println("No hay Productos agregados\n\n");
        } else {
            listProduct = editProductData.readProductData();
        }

        Scanner scanner = new Scanner(System.in);
        Product product;
        float totalPay = 0;
        boolean continueSale = true;

        while (continueSale) {

            System.out.print("\nCodigo del producto: ");
            int id = scanner.nextInt();
            product = listProduct.get(id);
            System.out.println("Producto: " + product.getNameProduct());
            if (product.getStock() > 0) {
                System.out.print("Cantidad: ");
                int amount = scanner.nextInt();
                if ((product.getStock() - amount) < 0) {
                    System.out.println("\nSolo exixten " + product.getStock() + " productos disponibles!!");
                } else {
                    totalPay = totalPay + (amount * product.getBudgetProduct());
                    product.setStock(product.getStock() - amount);
                    listProduct.set(id, product);
                    editProductData.writeProductData(listProduct);
                }
            } else {
                System.out.println("No Exixte producto en Stock");
            }

            System.out.print("\nAgregar producto(1=SI/0=NO): ");
            int continueSaleInt = scanner.nextInt();
            if (continueSaleInt == 0) {
                continueSale = false;
            }
        }

        System.out.println("Total a pagar: " + totalPay);
        Sale sale = new Sale(totalPay);
        EditSaleData editSaleData = new EditSaleData();
        ArrayList<Sale> listSale = new ArrayList();
        File fileSale = new File("data\\sale.json");
        if (fileSale.exists() && fileSale.length() == 0) {
            listSale = new ArrayList<>();
        } else {
            listSale = editSaleData.readSaleData();
        }
        listSale.add(sale);
        editSaleData.writeSaleData(listSale);
    }

    public void readSale() throws FileNotFoundException {

        EditSaleData editSaleData = new EditSaleData();
        File archivo = new File("data\\sale.json");
        ArrayList<Sale> listSale = new ArrayList<>();
        System.out.println("\t\t\t\tLista de ventas");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay ventas\n\n");
        } else {
            listSale = editSaleData.readSaleData();
            int i = 1;
            for (Sale sale : listSale) {
                System.out.println("\tVenta " + i + ": " + sale.getTotalSales());
                i = i + 1;
            }
        }
    }

    public float totalDialySale() throws FileNotFoundException {

        EditSaleData editSaleData = new EditSaleData();
        File archivo = new File("data\\sale.json");
        ArrayList<Sale> listSale = new ArrayList<>();
        float totalSale = 0;

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay ventas\n\n");
        } else {
            listSale = editSaleData.readSaleData();

            for (Sale sale : listSale) {
                totalSale = totalSale + sale.getTotalSales();
            }
        }
        return totalSale;
    }
}
