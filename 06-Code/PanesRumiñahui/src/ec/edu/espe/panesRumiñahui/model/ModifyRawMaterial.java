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
        ValidationUtil validationUtil = new ValidationUtil();
        Scanner readData = new Scanner(System.in);
        File file = new File("data\\rawMaterial.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();
        System.out.println("\t\t\t\tAgregar materia prima ");

        try {
            if (file.exists() && file.length() == 0) {
                System.out.println("\nNo hay materia prima\n\n");
            } else {
                listRawMaterial = editRawMaterialData.readRawMaterialData();
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        try {
            if (fileDirectExpense.exists() && fileDirectExpense.length() == 0) {
                System.out.println("\nNo hay productos\n\n");
            } else {
                listDirectExpense = editDirectExpenseData.readDirectExpenseData();
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

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
        rawMaterial = listRawMaterial.get(id);

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

        rawMaterial.setStock(rawMaterial.getStock() + amount);
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
        RawMaterial rawMaterial;
        Scanner readData = new Scanner(System.in);
        ValidationUtil validationUtil = new ValidationUtil();

        File archivo = new File("data\\rawMaterial.json");
        if (archivo.exists()) {
            if(archivo.length() == 0){
                listRawMaterial = new ArrayList<>();
            }else{
                listRawMaterial = editRawMaterialData.readRawMaterialData();
            }
            int id = listRawMaterial.size();
        System.out.println("\nId de la nueva materia prima: " + id);

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
            System.out.print("Precio de compra: ");
            String priceString = readData.nextLine();
            if (validationUtil.ValidateLetterString(priceString)) {
                continueValidation = false;
                price = validationUtil.getFloat(priceString);
            } else {
                System.out.println("Dato Invalido");
            }
        }

        int amount = 0;
        rawMaterial = new RawMaterial(id, name, price, amount);

        listRawMaterial.add(rawMaterial);
        editRawMaterialData.writeRawMaterialData(listRawMaterial);
        } else {
            System.out.println("\n\tNo se encontro el archivo, comuniquese con el servicio tecnico");
        }
    }
}
