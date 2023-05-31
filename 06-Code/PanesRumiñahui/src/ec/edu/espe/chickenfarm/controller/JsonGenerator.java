package ec.edu.espe.chickenfarm.controller;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ec.edu.espe.chickenfarm.model.Employee;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */

public class JsonGenerator {
    public void generateJsonFile(List<Employee> employee) {
        Gson gson = new Gson();
        String json = gson.toJson(employee);

        try (FileWriter writer = new FileWriter("DataPanesRumiñahui.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
}
