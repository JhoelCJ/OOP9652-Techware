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
        ValidationUtil validationUtil = new ValidationUtil();
        Scanner readData = new Scanner(System.in);
        File fileProduct = new File("data\\product.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();
        System.out.println("\t\t\t\tAgregar de Productos ");

        if (fileProduct.exists() && fileDirectExpense.exists()) {
            boolean addProduct = true;
            if (fileProduct.length() == 0) {
                System.out.println("\nNo hay productos\n\n");
                addProduct = false;
            } else {
                listProduct = editProductData.readProductData();
            }
            if (fileDirectExpense.length() == 0) {
                System.out.println("\nNo hay productos\n\n");
                addProduct = false;
            } else {
                listDirectExpense = editDirectExpenseData.readDirectExpenseData();
            }
            if (addProduct) {
                int id = 0;
                boolean continueValidation = true;
                while (continueValidation) {
                    System.out.print("\nId: ");
                    String idString = readData.nextLine();
                    if (validationUtil.ValidateLetterString(idString)) {
                        continueValidation = false;
                        id = validationUtil.getInt(idString);
                    } else {
                        System.out.println("Dato Invalido");
                    }
                }
                product = listProduct.get(id);

                String invoiceNumber = null;
                continueValidation = true;
                while (continueValidation) {
                    System.out.print("No. de Factura: ");
                    invoiceNumber = readData.nextLine();
                    if (validationUtil.ValidateLetterString(invoiceNumber)) {
                        continueValidation = false;
                    } else {
                        System.out.println("Dato Invalido");
                    }
                }

                int amount = 0;
                continueValidation = true;
                while (continueValidation) {
                    System.out.print("Cantidad: ");
                    String idString = readData.nextLine();
                    if (validationUtil.ValidateLetterString(idString)) {
                        continueValidation = false;
                        amount = validationUtil.getInt(idString);
                    } else {
                        System.out.println("Dato Invalido");
                    }
                }

                float price = 0;
                continueValidation = true;
                while (continueValidation) {
                    System.out.print("Total a pagar: ");
                    String priceString = readData.nextLine();
                    if (validationUtil.ValidateLetterString(priceString)) {
                        continueValidation = false;
                        price = validationUtil.getFloat(priceString);
                    } else {
                        System.out.println("Dato Invalido");
                    }
                }

                product.setStock(product.getStock() + amount);
                listProduct.set(id, product);
                editProductData.writeProductData(listProduct);
                directExpense = new DirectExpense(invoiceNumber, product.getNameProduct(), amount, price);
                listDirectExpense.add(directExpense);
                editDirectExpenseData.writeDirectExpenseData(listDirectExpense);
            }
        } else {
            System.out.println("\n\tNo se encontro el archivo, comuniquese con el servicio tecnico");
        }
    }

    public void readProduct() throws FileNotFoundException {
        EditProductData editProductData = new EditProductData();
        File archivo = new File("data\\product.json");
        ArrayList<Product> listProduct = new ArrayList<>();
        System.out.println("\t\t\t\tLista de Productos ");

        if (archivo.exists()) {
            if (archivo.length() == 0) {
                System.out.println("\nNo hay productos\n\n");
            } else {
                listProduct = editProductData.readProductData();

                for (Product product : listProduct) {
                    System.out.println(product.toString());
                }
            }
        } else {
            System.out.println("\n\tNo se encontro el archivo, comuniquese con el servicio tecnico");
        }
    }

    public void createProduct() throws FileNotFoundException {
        EditProductData editProductData = new EditProductData();
        ArrayList<Product> listProduct = new ArrayList<>();
        Product product;
        ValidationUtil validationUtil = new ValidationUtil();
        Scanner readData = new Scanner(System.in);
        File archivo = new File("data\\product.json");

        if (archivo.exists()) {
            if (archivo.length() == 0) {
                listProduct = new ArrayList<>();
            } else {
                listProduct = editProductData.readProductData();
            }
            int id = listProduct.size();
            System.out.println("\nId del nuevo producto: " + id);

            String name = null;
            boolean continueValidation = true;
            while (continueValidation) {
                System.out.print("Nombre del producto: ");
                name = readData.nextLine();
                if (validationUtil.ValidateLetterString(name)) {
                    continueValidation = false;
                } else {
                    System.out.println("Dato Invalido");
                }
            }

            float price = 0;
            continueValidation = true;
            while (continueValidation) {
                System.out.print("Total a pagar: ");
                String priceString = readData.nextLine();
                if (validationUtil.ValidateLetterString(priceString)) {
                    continueValidation = false;
                    price = validationUtil.getFloat(priceString);
                } else {
                    System.out.println("Dato Invalido");
                }
            }

            int amount = 0;
            product = new Product(id, name, price, amount);

            listProduct.add(product);
            editProductData.writeProductData(listProduct);
        } else {
            System.out.println("\n\tNo se encontro el archivo, comuniquese con el servicio tecnico");
        }
    }
}
