package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditDirectExpenseData;
import ec.edu.espe.panesrumiñahui.controller.EditFixedExpenseData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyExpense {

    public void readDirectExpense() throws FileNotFoundException {
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        File file = new File("data\\directExpense.json");
        ArrayList<DirectExpense> listDirectExpense = new ArrayList<>();
        System.out.println("\t\t\tGastos Directos\n ");

        try {
            if (file.exists() && file.length() == 0) {
                System.out.println("\nNo hay Gastos registrados\n\n");
            } else {
                listDirectExpense = editDirectExpenseData.readDirectExpenseData();
                for (DirectExpense directExpense : listDirectExpense) {
                    System.out.println(directExpense.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public void readFixedExpense() throws FileNotFoundException {
        EditFixedExpenseData editFixedExpenseData = new EditFixedExpenseData();
        File file = new File("data\\fixedExpense.json");
        ArrayList<FixedExpense> listFixedExpense = new ArrayList<>();
        System.out.println("\n\n\t\t\tGastos Fijos\n ");

        try {
            if (file.exists() && file.length() == 0) {
                System.out.println("\nNo hay Gastos registrados\n\n");
            } else {
                listFixedExpense = editFixedExpenseData.readFixedExpenseData();
                for (FixedExpense fixedExpense : listFixedExpense) {
                    System.out.println(fixedExpense.toString() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
