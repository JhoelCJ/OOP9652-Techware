package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditAdministratorData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class ModifyAdministrator {

    public void readAdministrator() throws FileNotFoundException {
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        File archivo = new File("data\\administrator.json");
        ArrayList<Administrator> listAdministrator = new ArrayList();
        System.out.println("\t\t\t\tAdministrator List");

        try {
            if (archivo.exists() && archivo.length() == 0) {
                System.out.println("No hay Administradores\n\n");
            } else {
                listAdministrator = editAdministratorData.readAdministratorData();
                for (Administrator administrator : listAdministrator) {
                    System.out.println(administrator.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public void createAdministrator() throws FileNotFoundException {
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        ArrayList<Administrator> listAdministrator = new ArrayList();
        Administrator administrator;
        Scanner readData = new Scanner(System.in);
        ValidationUtil validationUtil = new ValidationUtil();

        int id = 0;
        boolean continueValidation = true;
        while (continueValidation) {
            System.out.print("\nId: ");
            String idString = readData.nextLine();
            if (validationUtil.ValidateLetterString(idString)) {
                continueValidation = false;
                validationUtil.getInt(idString);
            } else {
                System.out.println("Dato Invalido");
            }
        }

        String name = null;
        continueValidation = true;
        while (continueValidation) {
            System.out.print("Nombre: ");
            name = readData.nextLine();
            if (validationUtil.ValidateLetterString(name)) {
                continueValidation = false;
            } else {
                System.out.println("Dato Invalido");
            }
        }

        int age = 0;
        continueValidation = true;
        while (continueValidation) {
            System.out.print("Edad: ");
            String ageString = readData.nextLine();
            if (validationUtil.ValidateLetterString(ageString)) {
                continueValidation = false;
                age = validationUtil.getInt(ageString);
            } else {
                System.out.println("Dato Invalido");
            }
        }

        String contactNumber;
        boolean validContactNumber = false;
        do {
            System.out.print("Numero telefonico: ");
            contactNumber = readData.nextLine();
            String patronNumerico = "^[0-9]+$";
            if (!contactNumber.matches(patronNumerico)) {
                System.out.println("El numero de contacto solo debe contener digitos numericos.");
            } else {
                validContactNumber = true;
            }
        } while (!validContactNumber);

        administrator = new Administrator(id, name, age, contactNumber);

        try {
            File archivo = new File("data\\administrator.json");
            if (archivo.exists() && archivo.length() == 0) {
                listAdministrator = new ArrayList<>();
            } else {
                listAdministrator = editAdministratorData.readAdministratorData();
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        listAdministrator.add(administrator);
        editAdministratorData.writeEmployeeData(listAdministrator);
    }
}
