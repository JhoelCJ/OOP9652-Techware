package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditSaleData;
import ec.edu.espe.panesrumiñahui.model.ModifyExpense;
import ec.edu.espe.panesrumiñahui.model.Inventory;
import ec.edu.espe.panesrumiñahui.model.Sale;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
                    modifyExpense.salary();
                    break;
                case 2:
                    inventory.totalDailySale();
                    break;
                case 3:
                    EditSaleData editSaleData = new EditSaleData();
                    File archivo = new File("sale.json");
                    ArrayList<Sale> listSale = new ArrayList<>();
                    System.out.println("\t\t\t\tVenta del dia");

                    if (archivo.exists() && archivo.length() == 0) {
                        System.out.println("No hay ventas\n\n");
                    } else {
                        listSale = editSaleData.readSaleData();
                        float totalSale = 0;
                        for (Sale sale : listSale) {
                            totalSale = totalSale + sale.getTotalSales();
                        }
                        totalSale = totalSale - 500;
                        System.out.println("Total: " + totalSale + "\n");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 4");
            }
        } while (option < 1 || option > 4);
    }

}
