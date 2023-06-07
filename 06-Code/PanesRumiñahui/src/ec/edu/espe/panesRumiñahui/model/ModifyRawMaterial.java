package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditDirectExpenseData;
import ec.edu.espe.panesrumiñahui.controller.EditRawMaterialData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyRawMaterial {

    public void addProductStock() throws FileNotFoundException {
        
        EditRawMaterialData editRawMaterialData = new EditRawMaterialData();
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        RawMaterial rawMaterial;
        DirectExpense directExpense;
        
        ValidationUtil validator = new ValidationUtil();
        Scanner readData = new Scanner(System.in);
        File file = new File("data\\rawMaterial.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();

        ValidationUtil validationUtil = new ValidationUtil();

        System.out.println("\t\t\t\tAgregar materia prima ");

        if (file.exists() && file.length() == 0) {
            System.out.println("\nNo hay materia prima\n\n");
        } else {
            listRawMaterial = editRawMaterialData.readRawMaterialData();
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
        
        int newStock = (rawMaterial.getStock() + amount);
        rawMaterial.getStock(newStock);
        listRawMaterial.set(id, rawMaterial);
        editRawMaterialData.writeRawMaterialData(listRawMaterial);

        directExpense = new DirectExpense(invoiceNumber, rawMaterial.getNameMaterial(), amount, price);
        listDirectExpense.add(directExpense);
        editDirectExpenseData.writeDirectExpenseData(listDirectExpense);
    }

    public void readRawMaterial() throws FileNotFoundException {

        EditRawMaterialData editRawMaterialData = new EditRawMaterialData();
        File archivo = new File("data\\rawMaterial.json");
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        System.out.println("\t\t\t\tLista de Materia Prima ");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("\nNo hay Materia Prima\n\n");
        } else {
            listRawMaterial = editRawMaterialData.readRawMaterialData();
            for (RawMaterial rawMaterial : listRawMaterial) {
                System.out.println(rawMaterial.toString());
            }
        }
    }

    public void createRawMaterial() throws FileNotFoundException {

        EditRawMaterialData editRawMaterialData = new EditRawMaterialData();
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        ValidationUtil validationUtil = new ValidationUtil();
        RawMaterial rawMaterial;
        Scanner readData = new Scanner(System.in);

        System.out.print("\nId: ");
        String idInput = readData.nextLine();
        while (!validationUtil.validateInt(idInput)) {
            System.out.println("El id debe ser un valor numerico.");
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

        System.out.print("Precio de compra: ");
        String priceInput = readData.nextLine();
        while (!validationUtil.validateFloat(priceInput)) {
            System.out.println("El precio de compra debe ser un valor numerico.");
            System.out.print("Precio de compra: ");
            priceInput = readData.nextLine();
        }
        float price = validationUtil.getFloat(priceInput);

        int amount = 0;
        rawMaterial = new RawMaterial(id, name, price, amount);

        File archivo = new File("data\\rawMaterial.json");
        if (archivo.exists() && archivo.length() == 0) {
            listRawMaterial = new ArrayList<>();
        } else {
            listRawMaterial = editRawMaterialData.readRawMaterialData();
        }

        listRawMaterial.add(rawMaterial);
        editRawMaterialData.writeRawMaterialData(listRawMaterial);
    }
}
