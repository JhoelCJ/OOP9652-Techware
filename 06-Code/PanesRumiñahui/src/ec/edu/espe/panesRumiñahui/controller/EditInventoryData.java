package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditInventoryData {
    
    public void witeInventoryData(List<Inventory> inventory) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(inventory);

        try (FileWriter writer = new FileWriter("inventory.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public Inventory readInventoryData(){
        Gson gson = new Gson();
        Inventory inventory = new Inventory();
        
        try (FileReader reader = new FileReader("inventory.json")) {
            inventory = gson.fromJson(reader, Inventory.class);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }
        
        return inventory;
    }
}
