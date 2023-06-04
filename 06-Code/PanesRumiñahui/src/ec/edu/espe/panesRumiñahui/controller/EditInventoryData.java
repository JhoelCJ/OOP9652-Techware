package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditInventoryData {
    
    public void witeInventoryData(List<Inventory> inventory) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(inventory);

        try (FileWriter writer = new FileWriter("inventory.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public  ArrayList<Inventory> readInventoryData() throws FileNotFoundException{
        ArrayList<Inventory> listInventory = new ArrayList();
        
        try (FileReader reader = new FileReader("inventory.json")) {
            Gson gson = new Gson();
            Type arrayListInventory = new TypeToken<ArrayList<Inventory>>(){}.getType();
            listInventory = gson.fromJson(reader, arrayListInventory);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }
        
        return listInventory;
    }
}
