package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditDirectExpenseData;
import ec.edu.espe.panesrumiñahui.controller.EditFixedExpenseData;
import ec.edu.espe.panesrumiñahui.controller.EditSaleData;
import ec.edu.espe.panesrumiñahui.model.Sale;
import ec.edu.espe.panesrumiñahui.model.FixedExpense;
import ec.edu.espe.panesrumiñahui.model.DirectExpense;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Gabriel Calvache
 * @author Gabriel Baez
 * @author Jilmar Calderon
 */
public class Budget {

    public float CalculateExpense() throws FileNotFoundException{
        EditFixedExpenseData editFixedExpenseData = new EditFixedExpenseData();
        EditDirectExpenseData editDirectExpenseData = new EditDirectExpenseData();
        File fileFixedExpense = new File("data\\fixedExpense.json");
        File fileDirectExpense = new File("data\\directExpense.json");
        ArrayList<FixedExpense> listFixedExpense = new ArrayList();
        ArrayList<DirectExpense> listDirectExpense = new ArrayList();
        float totalFixedExpense = 0;
        float totalDirectExpense = 0;

        if (fileFixedExpense.exists() && fileFixedExpense.length() == 0) {
            System.out.println("\n\n");
        } else {
            listFixedExpense = editFixedExpenseData.readFixedExpenseData();
            for (FixedExpense fixedExpense : listFixedExpense) {
                totalFixedExpense = totalFixedExpense + fixedExpense.getAmount();
            }
        }
        if (fileDirectExpense.exists() && fileDirectExpense.length() == 0) {
            System.out.println("\n\n");
        } else {
            listDirectExpense = editDirectExpenseData.readDirectExpenseData();
            for (DirectExpense directExpense : listDirectExpense) {
                totalDirectExpense = totalDirectExpense + directExpense.getPrice();
            }
        }
        return totalFixedExpense + totalDirectExpense;
    }
    
    public float CalculateIncome() throws FileNotFoundException{
        EditSaleData editSaleData = new EditSaleData();
        File file = new File("data\\sale.json");
        ArrayList<Sale> listSale = new ArrayList();
        float totalSale = 0;

        if (file.exists() && file.length() == 0) {
            System.out.println("No hay ventas\n\n");
        } else {
            listSale = editSaleData.readSaleData();
            for (Sale sale : listSale) {
                totalSale = totalSale + sale.getTotalSales();
            }
        }
        return totalSale;
    }
}
