package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ec.edu.espe.panesrumiñahui.model.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Gabriel Calvache, Techware, DCCO-ESPE
 */
public class EditEmployeeData {

    public void writeEmployeeData(ArrayList<Employee> employee) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employee);

        try (FileWriter writer = new FileWriter("employee.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error al generar JSON file: " + e.getMessage());
        }
    }

    public ArrayList<Employee> readEmployeeData() throws FileNotFoundException {

        ArrayList<Employee> listEmployees = new ArrayList();

        try (FileReader reader = new FileReader("employee.json")) {
            Gson gson = new Gson();
            Type arrayListEmployee = new TypeToken<ArrayList<Employee>>() {
            }.getType();
            listEmployees = gson.fromJson(reader, arrayListEmployee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listEmployees;
    }

}
