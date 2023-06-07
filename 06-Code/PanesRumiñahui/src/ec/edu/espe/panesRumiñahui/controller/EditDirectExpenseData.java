package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.DirectExpense;
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
public class EditDirectExpenseData {

    public void writeDirectExpenseData(List<DirectExpense> directExpense) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(directExpense);

        try (FileWriter writer = new FileWriter("data\\directExpense.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public ArrayList<DirectExpense> readDirectExpenseData() throws FileNotFoundException {

        ArrayList<DirectExpense> listDirectExpense = new ArrayList();

        try (FileReader reader = new FileReader("data\\directExpense.json")) {
            Gson gson = new Gson();
            Type arrayListDirectExpense = new TypeToken<ArrayList<DirectExpense>>() {
            }.getType();
            listDirectExpense = gson.fromJson(reader, arrayListDirectExpense);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }

        return listDirectExpense;
    }
}
