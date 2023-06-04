package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import ec.edu.espe.panesrumiñahui.model.Employee;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import ec.edu.espe.panesrumiñahui.model.Sale;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditSaleData {
    
    public void writeSaleData(List<Sale> sale) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(sale);

        try (FileWriter writer = new FileWriter("sale.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
        
    }
}