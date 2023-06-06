package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesRumiñahui.model.Budget;
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
public class EditBudgetData {

    public void writeBudgetData(List<Budget> budget) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(budget);

        try (FileWriter writer = new FileWriter("budget.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error al generar JSON file: " + e.getMessage());
        }

    }

    public ArrayList<Budget> readBudgetData() throws FileNotFoundException {

        ArrayList<Budget> listBudget = new ArrayList<>();

        try (FileReader reader = new FileReader("budget.json")) {
            Gson gson = new Gson();
            Type arrayListBudget = new TypeToken<ArrayList<Budget>>() {
            }.getType();
            listBudget = gson.fromJson(reader, arrayListBudget);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }

        return listBudget;
    }
}
