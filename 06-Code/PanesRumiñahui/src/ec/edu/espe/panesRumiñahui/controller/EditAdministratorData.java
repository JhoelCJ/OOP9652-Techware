package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.panesrumiñahui.model.Administrator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Baez Gabriel, Techware, DCCO-ESPE
 */

public class EditAdministratorData {
    public void writeAdministratorData(Administrator administrator) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(administrator);

        try (FileWriter writer = new FileWriter("administrator.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public void readAdministratorData() throws FileNotFoundException{
        FileReader reader = new FileReader("administrator.json");
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = stringBuilder.toString();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Administrator administrator = gson.fromJson(jsonString, Administrator.class);
        System.out.println(administrator.toString());
    }
}
