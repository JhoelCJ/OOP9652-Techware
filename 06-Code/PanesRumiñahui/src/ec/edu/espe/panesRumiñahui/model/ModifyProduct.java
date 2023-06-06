package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditDirectExpenseData;
import ec.edu.espe.panesrumiñahui.controller.EditProductData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyProduct {
    public void addProductStock() throws FileNotFoundException{
        EditProductData editProductData = new EditProductData();
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        Product product;
        DirectExpense directExpense;
        Scanner readData = new Scanner(System.in);
        File fileProduct = new File("data\\product.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();
        System.out.println("\t\t\t\tAgregar de Productos ");

        if (fileProduct.exists() && fileProduct.length() == 0) {
            System.out.println("\nNo hay productos\n\n");
        } else {
            listProduct = editProductData.readProductData();
        }
        if (fileDirectExpense.exists() && fileDirectExpense.length() == 0) {
            System.out.println("\nNo hay productos\n\n");
        } else {
            listDirectExpense = editDirectExpenseData.readDirectExpenseData();
        }
        
        System.out.print("Id: ");
        int id = readData.nextInt();
        product = listProduct.get(id);
        System.out.print("No. de Factura: ");
        String invoiceNumber = readData.next();
        System.out.print("Cantidad: ");
        int amount = readData.nextInt();
        System.out.print("Total a pagar: ");
        float price = readData.nextFloat();
        
        product.setStock(product.getStock() + amount);
        listProduct.set(id, product);
        editProductData.writeProductData(listProduct);
        directExpense = new DirectExpense(invoiceNumber, product.getNameProduct(), amount, price);
        listDirectExpense.add(directExpense);
        editDirectExpenseData.writeDirectExpenseData(listDirectExpense);
    }
    
    public void readProduct() throws FileNotFoundException {
        EditProductData editProductData = new EditProductData();
        File archivo = new File("data\\product.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        System.out.println("\t\t\t\tLista de Productos ");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("\nNo hay productos\n\n");
        } else {
            listProduct = editProductData.readProductData();
            
            for(Product product : listProduct){
                System.out.println(product.toString());
            }
        }
    }
    
    public void createProduct() throws FileNotFoundException{
        EditProductData editProductData = new EditProductData();
        ArrayList<Product> listProduct = new ArrayList<>();
        Product product;
        Scanner readData = new Scanner(System.in);
        
        System.out.print("\nId: ");
        int id = readData.nextInt();
        System.out.print("Nombre del producto: ");
        String name = readData.next();
        System.out.print("Precio de venta: ");
        float price = readData.nextFloat();
        int amount = 0;
        product = new Product(id, name, price, amount);
        File archivo = new File("data\\product.json");
        if (archivo.exists() && archivo.length() == 0) {
            listProduct = new ArrayList<>();
        } else {
            listProduct = editProductData.readProductData();
        }
        listProduct.add(product);
        editProductData.writeProductData(listProduct);
    }
}
