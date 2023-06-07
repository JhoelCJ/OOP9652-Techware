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
        ValidationUtil validationUtil = new ValidationUtil();
        FixedExpense fixedExpense;
        Scanner readData = new Scanner(System.in);
        String argument = null;
        float amount = 0;
        
        boolean continueValidation = true;
        while (continueValidation) {
            System.out.print("\nArgumento: ");
            argument = readData.nextLine();
            if (validationUtil.ValidateLetterString(argument)) {
                continueValidation = false;
            } else {
                System.out.println("\n\tDato Invalido");
            }
        }
        
        continueValidation = true;
        while(continueValidation){
            System.out.print("Monto: ");
            String amountString = readData.nextLine();
            if (validationUtil.validateFloat(amountString)) {
                amount = validationUtil.getFloat(amountString);
                continueValidation = false;
            } else {
                System.out.println("\n\tDato Invalido");
            }
        }
        
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
