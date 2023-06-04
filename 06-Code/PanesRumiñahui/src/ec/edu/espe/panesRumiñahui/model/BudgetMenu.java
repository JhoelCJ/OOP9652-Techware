package ec.edu.espe.panesRumiñahui.model;

import ec.edu.espe.panesrumiñahui.model.Inventory;
import java.util.Scanner;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class BudgetMenu {

    public void budgetMenu() {

        Scanner scanner = new Scanner(System.in);
        Budget budget = new Budget();

        int option;

        do {

            System.out.println("\n1. Presupuesto del Mes ");
            System.out.println("2. Ver dinero disponible ");
            System.out.println("3. Pago a los empleados ");
            System.out.println("4. Gastos de compras: ");
            System.out.println("5. IVA ");
            System.out.println("6. Salir ");
            System.out.print("\n\tIngrese una opcion: ");
            option = scanner.nextInt();

            switch (option) {

                case 1:
                    budget.budget();
                    break;
                case 2:

                    break;
                case 3:
                    budget.salary();

                    break;
                case 4:
                    budget.buy();
                    break;
                case 5:
                    budget.taxes();
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 6");
            }
        } while (option < 1 || option > 6);
    }

}
