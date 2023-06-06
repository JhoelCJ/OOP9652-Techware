package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.Administrator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditAdministratorData {

    public void writeEmployeeData(ArrayList<Administrator> administrator) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(administrator);

        try (FileWriter writer = new FileWriter("administrator.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error al generar JSON file: " + e.getMessage());
        }
    }

    public ArrayList<Administrator> readAdministratorData() throws FileNotFoundException {
        ArrayList<Administrator> listAdministrator = new ArrayList();

        try (FileReader reader = new FileReader("administrator.json")) {
            Gson gson = new Gson();
            Type arrayListAdministrator = new TypeToken<ArrayList<Administrator>>() {
            }.getType();
            listAdministrator = gson.fromJson(reader, arrayListAdministrator);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listAdministrator;
    }
}
