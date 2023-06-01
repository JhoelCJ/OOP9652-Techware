package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditInventoryData;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Baez Gabriel, Techware, DCCO-ESPE
 */

public class Inventory {
    public void writeInventoryRawMaterial(){
        EditInventoryData editInventoryData = new EditInventoryData();
        Scanner readData = new Scanner(System.in);
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("Name: ");
        String name = readData.next();
        RawMaterial rawMaterial = new RawMaterial(id, name);
        editInventoryData.writeInventoryRawMaterial(rawMaterial);
    }
    
    public void writeInventoryProduct(){
        EditInventoryData editInventoryData = new EditInventoryData();
        Scanner readData = new Scanner(System.in);
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("Name: ");
        String name = readData.next();
        Product product = new Product(id, name);
        editInventoryData.writeInventoryProduct(product);
    }
    
    public void readInventory() throws FileNotFoundException{
        EditInventoryData editInventoryData = new EditInventoryData();
        editInventoryData.readInventoryData();
    }
}
