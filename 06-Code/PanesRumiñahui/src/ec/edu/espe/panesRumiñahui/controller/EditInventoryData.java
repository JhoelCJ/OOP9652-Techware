package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import ec.edu.espe.panesrumiñahui.model.Product;
import ec.edu.espe.panesrumiñahui.model.RawMaterial;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Calderón Jilmar, Techware, DCCO-ESPE
 * @author Baez Gabriel, Techware, DCCO-ESPE
 */
public class EditInventoryData {
    
    public void writeInventoryProduct(Product product) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(product);

        try (FileWriter writer = new FileWriter("inventoryProduct.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public void writeInventoryRawMaterial(RawMaterial rawMaterial) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(rawMaterial);

        try (FileWriter writer = new FileWriter("inventoryRawMaterial.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public void readInventoryData() throws FileNotFoundException{
        FileReader readerRawMaterial = new FileReader("inventoryRawMaterial.json");
        FileReader readerProduct = new FileReader("inventoryProduct.json");
        StringBuilder stringBuilderRawMaterial = new StringBuilder();
        StringBuilder stringBuilderProduct = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(readerProduct)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilderProduct.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = stringBuilderProduct.toString();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Product inventoryProduct = gson.fromJson(jsonString, Product.class);
        System.out.println(inventoryProduct.toString());
        
        try (BufferedReader bufferedReader = new BufferedReader(readerRawMaterial)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilderRawMaterial.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonStringRawMaterial = stringBuilderRawMaterial.toString();
        GsonBuilder gsonBuilderRawMaterial = new GsonBuilder();
        gsonBuilderRawMaterial.setPrettyPrinting();
        Gson gsonRawMaterial = gsonBuilder.create();
        RawMaterial inventoryRawMaterial = gsonRawMaterial.fromJson(jsonStringRawMaterial, RawMaterial.class);
        System.out.println(inventoryRawMaterial.toString());
    }
}
