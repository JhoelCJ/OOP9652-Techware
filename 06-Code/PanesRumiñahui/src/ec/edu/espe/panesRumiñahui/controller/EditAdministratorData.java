package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.panesrumiñahui.model.Administrator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class EditAdministratorData {
    public void writeAdministratorData(List<Administrator> administrator) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(administrator);

        try (FileWriter writer = new FileWriter("administrator.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
}
