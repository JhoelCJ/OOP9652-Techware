package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.panesrumiñahui.model.Employee;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditEmployeeData {
    
    public void writeEmployeeData(Employee employee) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employee);

        try (FileWriter writer = new FileWriter("employee.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    
}
