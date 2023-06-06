package ec.edu.espe.panesrumiñahui.model;

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

    public void addProductStock() throws FileNotFoundException {
        
        EditProductData editProductData = new EditProductData();
        Product product;
        Scanner readData = new Scanner(System.in);
        File archivo = new File("product.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        System.out.println("\t\t\t\tLista de Productos ");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("\nNo hay productos\n\n");
        } else {
            listProduct = editProductData.readProductData();
        }

        System.out.print("Id: ");
        int id = readData.nextInt();
        product = listProduct.get(id);
        System.out.print("Cantidad: ");
        int amount = readData.nextInt();
        product.setStock(product.getStock() + amount);
        listProduct.set(id, product);
        editProductData.writeProductData(listProduct);
    }

    public void readProduct() throws FileNotFoundException {
        
        EditProductData editProductData = new EditProductData();
        File archivo = new File("product.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        System.out.println("\t\t\t\tLista de Productos ");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("\nNo hay productos\n\n");
        } else {
            listProduct = editProductData.readProductData();

            for (Product product : listProduct) {
                System.out.println(product.toString());
            }
        }
    }

    public void createProduct() throws FileNotFoundException {

        EditProductData editProductData = new EditProductData();
        ArrayList<Product> listProduct = new ArrayList<>();

        Product product;
        Scanner readData = new Scanner(System.in);

        System.out.print("\nId: ");
        int id = readData.nextInt();
        System.out.print("Nombre del producto: ");
        String name = readData.next();
        System.out.print("Precio: ");
        float price = readData.nextFloat();
        System.out.print("Cantidad: ");
        int amount = readData.nextInt();
        product = new Product(id, name, price, amount);
        File archivo = new File("product.json");
        if (archivo.exists() && archivo.length() == 0) {
            listProduct = new ArrayList<>();
        } else {
            listProduct = editProductData.readProductData();
        }
        listProduct.add(product);
        editProductData.writeProductData(listProduct);
    }
}
