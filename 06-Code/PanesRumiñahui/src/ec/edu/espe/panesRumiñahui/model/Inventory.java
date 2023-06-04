package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditInventoryData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Inventory {
    public void inventory(){
        
    }
    
    public void readInventory(){
        /*EditInventoryData editInventoryData = new EditInventoryData();
        Inventory inventory = editInventoryData.readInventoryData();
        System.out.println(inventory);*/
    }
    
    public void writeInventory(){
        ArrayList<Inventory> inventory = new ArrayList<>();
        EditInventoryData editInventoryData = new EditInventoryData();
        editInventoryData.witeInventoryData(inventory);
    }
}
