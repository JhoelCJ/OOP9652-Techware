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

    public void addProductStock() throws FileNotFoundException {

        EditProductData editProductData = new EditProductData();
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        Product product;
        DirectExpense directExpense;

        ValidationUtil validator = new ValidationUtil();
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

        int id=0;
        boolean validId = false;
        do {
            System.out.print("\nId: ");
            String idString = readData.nextLine();

            validId = validator.validateInt(idString);
            if (!validId) {
                System.out.println("El ID ingresado no es valido. Por favor, ingrese un ID existente.");
            }else{
                id = validator.getInt(idString);
            }
        } while (!validId);

        product = listProduct.get(id);

        String invoiceNumber;
        boolean validInvoiceNumber = false;
        do {
            System.out.print("No. de Factura: ");
            invoiceNumber = readData.nextLine();
            validInvoiceNumber = validator.ValidateNumberString(invoiceNumber);
            if (!validInvoiceNumber) {
                System.out.println("El numero de factura solo debe contener letras. Por favor, ingrese un valor valido.");
            }
        } while (!validInvoiceNumber);

        int amount=0;
        boolean validAmount = false;
        do {
            System.out.print("Cantidad: ");
            String amountString = readData.nextLine();
            validAmount = validator.validateInt(amountString);
            if (!validAmount) {
                System.out.println("La cantidad ingresada no es valida. Por favor, ingrese un valor numerico positivo.");
            }else{
                amount = validator.getInt(amountString);
            }
        } while (!validAmount);

        float price=0;
        boolean validPrice = false;
        do {
            System.out.print("Total a pagar: ");
            String priceString = readData.nextLine();
            validPrice = validator.validateFloat(priceString);
            if (!validPrice) {
                System.out.println("El precio ingresado no es valido. Por favor, ingrese un valor numerico positivo.");
            }else{
                price = validator.getFloat(priceString);
            }
        } while (!validPrice);

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

            for (Product product : listProduct) {
                System.out.println(product.toString());
            }
        }
    }

    public void createProduct() throws FileNotFoundException {

        EditProductData editProductData = new EditProductData();
        ArrayList<Product> listProduct = new ArrayList<>();
        ValidationUtil validationUtil = new ValidationUtil();
        Product product;
        Scanner readData = new Scanner(System.in);

        System.out.print("\nId: ");
        String idInput = readData.nextLine();
        while (!validationUtil.validateInt(idInput)) {
            System.out.println("El id debe ser un valor numerico entero.");
            System.out.print("Id: ");
            idInput = readData.nextLine();
        }
        int id = validationUtil.getInt(idInput);

        System.out.print("Nombre del producto: ");
        String name = readData.nextLine();
        while (!validationUtil.ValidateLetterString(name)) {
            System.out.println("El nombre del producto solo debe contener letras (mayusculas o minusculas).");
            System.out.print("Nombre del producto: ");
            name = readData.nextLine();
        }

        System.out.print("Precio de venta: ");
        String priceInput = readData.nextLine();
        while (!validationUtil.validateFloat(priceInput)) {
            System.out.println("El precio de venta debe ser ingresado con punto para los decimales.");
            System.out.print("Precio de venta: ");
            priceInput = readData.nextLine();
        }
        float price = validationUtil.getFloat(priceInput);

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
