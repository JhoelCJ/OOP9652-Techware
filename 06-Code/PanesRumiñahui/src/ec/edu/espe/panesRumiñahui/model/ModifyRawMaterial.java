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
    public void addProductStock() throws FileNotFoundException{
        EditRawMaterialData editRawMaterialData = new EditRawMaterialData();
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        RawMaterial rawMaterial;
        DirectExpense directExpense;
        Scanner readData = new Scanner(System.in);
        File file = new File("data\\rawMaterial.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();
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
        
        System.out.print("Id: ");
        int id = readData.nextInt();
        rawMaterial = listRawMaterial.get(id);
        System.out.print("No. de Factura: ");
        String invoiceNumber = readData.next();
        System.out.print("Cantidad: ");
        int amount = readData.nextInt();
        System.out.print("Total a pagar: ");
        float price = readData.nextFloat();
        
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
            for(RawMaterial rawMaterial : listRawMaterial){
                System.out.println(rawMaterial.toString());
            }
        }
    }
    
    public void createRawMaterial() throws FileNotFoundException{
        EditRawMaterialData editRawMaterialData = new EditRawMaterialData();
        ArrayList<RawMaterial> listRawMaterial = new ArrayList<>();
        RawMaterial rawMaterial;
        Scanner readData = new Scanner(System.in);
        
        System.out.print("\nId: ");
        int id = readData.nextInt();
        System.out.print("Nombre del producto: ");
        String name = readData.next();
        System.out.print("Precio de compra: ");
        float price = readData.nextFloat();
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
