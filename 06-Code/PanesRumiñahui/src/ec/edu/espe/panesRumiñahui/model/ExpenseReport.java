package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditFixedExpenseData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class ExpenseReport {
    public void addFixedExpense() throws FileNotFoundException{
        EditFixedExpenseData editFixedExpenseData = new EditFixedExpenseData();
        ArrayList<FixedExpense> listFixedExpense = new ArrayList();
        FixedExpense fixedExpense;
        Scanner readData = new Scanner(System.in);
        
        System.out.print("\nArgumento: ");
        String argument = readData.next();
        System.out.print("Monto: ");
        float amount = readData.nextFloat();
        
        File file = new File("data\\fixedExpense.json");
        if (file.exists() && file.length() == 0) {
            listFixedExpense = new ArrayList<>();
        } else {
            listFixedExpense = editFixedExpenseData.readFixedExpenseData();
        }
        
        fixedExpense = new FixedExpense(argument, amount);
        listFixedExpense.add(fixedExpense);
        editFixedExpenseData.writeFixedExpenseData(listFixedExpense);
    }
}
