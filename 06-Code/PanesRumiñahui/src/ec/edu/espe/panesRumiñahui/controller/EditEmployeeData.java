package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.panesrumiñahui.model.Employee;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class EditEmployeeData {
    
    public void writeEmployeeData(List<Employee> employee) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(employee);

        try (FileWriter writer = new FileWriter("employee.json")) {
            writer.write(json);
            System.out.println("JSON file generated");
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }
    
    public void saveData(){
        
    }
    
    public void readData(){
        
    }
}
