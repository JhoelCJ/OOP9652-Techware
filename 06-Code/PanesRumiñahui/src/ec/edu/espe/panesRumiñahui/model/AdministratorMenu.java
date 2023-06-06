package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesRumiñahui.model.BudgetMenu;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *@author Jilmar Calderon, Techware, DCCO-ESPE
 *@author Diego Casignia, Techware, DCCO-ESPE
 */

public class AdministratorMenu {
    
    public void administratorMenu() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        boolean continueMenu = true;
        
        while(continueMenu){
            InventoryMenu inventoryMenu = new InventoryMenu();
            ModifyEmployee modifyEmployee = new ModifyEmployee();
            BudgetMenu budgetMenu = new BudgetMenu();
            ExpenseReport expenseReport = new ExpenseReport();
            ModifyEmployeeMenu modifyEmployeeMenu = new ModifyEmployeeMenu();
            ModifyAdministrator modifyAdministrator = new ModifyAdministrator();
            ModifyInventoryMenu modifyInventoryMenu = new ModifyInventoryMenu();
            ValidationUtil validationUtil = new ValidationUtil();
            
            System.out.println ("\n1. Ver empleado: ");
            System.out.println ("2. Modificar empleado: ");
            System.out.println ("3. Ver inventario: ");
            System.out.println ("4. Modificar inventario: ");
            System.out.println ("5. Ver administrador: ");
            System.out.println ("6. Agregar administrador: ");
            System.out.println ("7. Reporte y Presupuesto");
            System.out.println ("8. Agregar Gasto Fijo");
            System.out.println ("9. Salir");
            System.out.print("\n\tIngrese una opcion: ");
            String option = scanner.next();
            if(validationUtil.validateInt(option)){
                switch (validationUtil.getInt(option)) {
                    case 1:
                        modifyEmployee.readEmployee();
                        break;
                    case 2:
                        modifyEmployeeMenu.modifyEmployeeMenu();
                        break;
                    case 3:
                        inventoryMenu.inventoryMenu();
                        break;
                    case 4:
                        modifyInventoryMenu.modifyInventoryMenu();
                        break;
                    case 5:
                        modifyAdministrator.readAdministrator();
                        break;
                    case 6:
                        modifyAdministrator.createAdministrator();
                        break;
                    case 7:
                        budgetMenu.budgetMenu();
                        break;
                    case 8:
                        expenseReport.addFixedExpense();
                        break;
                    case 9:
                        continueMenu = false;
                        break;
                    default:
                        System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 8");
                }
            }else{
                System.out.println("\nDato Inalido!!");
            }
        }
    }
}
