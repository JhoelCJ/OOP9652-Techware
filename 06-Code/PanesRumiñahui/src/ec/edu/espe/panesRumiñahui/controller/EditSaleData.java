package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.Sale;
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
public class EditSaleData {

    public void writeSaleData(List<Sale> sale) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(sale);

        try (FileWriter writer = new FileWriter("data\\sale.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public ArrayList<Sale> readSaleData() throws FileNotFoundException {

        ArrayList<Sale> listSale = new ArrayList();

        try (FileReader reader = new FileReader("data\\sale.json")) {
            Gson gson = new Gson();
            Type arrayListSale = new TypeToken<ArrayList<Sale>>() {
            }.getType();
            listSale = gson.fromJson(reader, arrayListSale);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }
        return listSale;
    }
}
