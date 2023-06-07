package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.Product;
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
public class EditProductData {

    public void writeProductData(List<Product> product) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(product);

        try (FileWriter writer = new FileWriter("data\\product.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public ArrayList<Product> readProductData() throws FileNotFoundException {

        ArrayList<Product> listProduct = new ArrayList();

        try (FileReader reader = new FileReader("data\\product.json")) {
            Gson gson = new Gson();
            Type arrayListProduct = new TypeToken<ArrayList<Product>>() {
            }.getType();
            listProduct = gson.fromJson(reader, arrayListProduct);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }

        return listProduct;
    }
}
