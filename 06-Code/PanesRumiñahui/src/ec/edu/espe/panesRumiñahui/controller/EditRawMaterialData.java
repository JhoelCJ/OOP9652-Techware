package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.RawMaterial;
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
public class EditRawMaterialData {

    public void writeRawMaterialData(List<RawMaterial> inventory) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(inventory);

        try (FileWriter writer = new FileWriter("data\\rawMaterial.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public ArrayList<RawMaterial> readRawMaterialData() throws FileNotFoundException {

        ArrayList<RawMaterial> listRawMaterial = new ArrayList();

        try (FileReader reader = new FileReader("data\\rawMaterial.json")) {
            Gson gson = new Gson();
            Type arrayListRawMaterial = new TypeToken<ArrayList<RawMaterial>>() {
            }.getType();
            listRawMaterial = gson.fromJson(reader, arrayListRawMaterial);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }

        return listRawMaterial;
    }
}
