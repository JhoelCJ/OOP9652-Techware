package ec.edu.espe.panesrumiñahui.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyEmployeeMenu {

    public void modifyEmployeeMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ValidationUtil validationUtil = new ValidationUtil();

        boolean continueMenu = true;
        while (continueMenu) {
            ModifyEmployee modifyEmployee = new ModifyEmployee();

            System.out.println("\n1. Agregar Empleado");
            System.out.println("2. Elimiar ");
            System.out.println("3. Salir");
            System.out.print("\n\tIngrese una opcion: ");
            String option = scanner.nextLine();
            if (validationUtil.validateInt(option)) {
                switch (validationUtil.getInt(option)) {
                    case 1:
                        modifyEmployee.createEmployee();
                        break;
                    case 2:
                        modifyEmployee.deleteEmployee();
                        break;
                    case 3:
                        continueMenu = false;
                        break;
                    default:
                        System.out.println("Opcion invalida, selecione otra vez una opcion del 1 al 3");
                }
            } else {
                System.out.println("\nDato Invalido!!");
            }
        }
    }
}
