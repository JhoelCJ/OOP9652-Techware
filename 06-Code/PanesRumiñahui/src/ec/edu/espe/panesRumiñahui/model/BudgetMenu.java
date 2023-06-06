package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.model.ModifyExpense;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class BudgetMenu {

    public void budgetMenu() throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        ModifyExpense modifyExpense = new ModifyExpense();
        Budget budget = new Budget();

        int option;

        do {
            System.out.println("\n1. Gastos ");
            System.out.println("2. Ingresos ");
            System.out.println("3. Ingreso Neto ");
            System.out.println("4. Salir ");
            System.out.print("\n\tIngrese una opcion: ");
            option = scanner.nextInt();

            switch (option) {

                case 1:
                    modifyExpense.readDirectExpense();
                    modifyExpense.readFixedExpense();
                    System.out.println("\nTotal Gastos: " + budget.CalculateExpense() + "\n");
                    break;
                case 2:
                    inventory.dailySale();
                    System.out.println("\n\nTotal Ingresos: " + inventory.totalDailySale() + "\n");
                    break;
                case 3:
                    System.out.println("\n\t\tIngreso Neto\n");
                    System.out.println("Total Gastos: " + budget.CalculateExpense() + "\n");
                    System.out.println("Total Ingresos: " + inventory.totalDailySale() + "\n");
                    System.out.println("\nTotal Ingreso Neto: " + (inventory.totalDailySale()-budget.CalculateExpense()) + "\n");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 4");
            }
        } while (option < 1 || option > 4);
    }

}
