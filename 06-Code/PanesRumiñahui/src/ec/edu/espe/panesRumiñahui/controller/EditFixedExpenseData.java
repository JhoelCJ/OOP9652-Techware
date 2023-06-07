package ec.edu.espe.panesrumiñahui.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.panesrumiñahui.model.FixedExpense;
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
public class EditFixedExpenseData {

    public void writeFixedExpenseData(List<FixedExpense> fixedExpense) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(fixedExpense);

        try (FileWriter writer = new FileWriter("data\\fixedExpense.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error generating JSON file: " + e.getMessage());
        }
    }

    public ArrayList<FixedExpense> readFixedExpenseData() throws FileNotFoundException {

        ArrayList<FixedExpense> listFixedExpense = new ArrayList();

        try (FileReader reader = new FileReader("data\\fixedExpense.json")) {
            Gson gson = new Gson();
            Type arrayListFixedExpense = new TypeToken<ArrayList<FixedExpense>>() {
            }.getType();
            listFixedExpense = gson.fromJson(reader, arrayListFixedExpense);
        } catch (IOException | JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
        }

        return listFixedExpense;
    }
}
