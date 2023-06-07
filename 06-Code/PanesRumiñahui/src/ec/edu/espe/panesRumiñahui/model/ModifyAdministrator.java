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

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay Administradores\n\n");
        } else {
            listAdministrator = editAdministratorData.readAdministratorData();
            for (Administrator administrator : listAdministrator) {
                System.out.println(administrator.toString());
            }
        }
    }

    public void createAdministrator() throws FileNotFoundException {
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        ArrayList<Administrator> listAdministrator = new ArrayList<>();
        ValidationUtil validationUtil = new ValidationUtil();
        Administrator administrator;
        Scanner readData = new Scanner(System.in);

        System.out.print("\nId: ");
        int id = 0;
        boolean validId = false;
        do {
            String idInput = readData.next();
            if (validationUtil.validateInt(idInput)) {
                id = validationUtil.getInt(idInput);
                validId = true;
            } else {
                System.out.println("El ID debe ser un número entero. Por favor, ingrese un ID válido.");
            }
        } while (!validId);

        System.out.print("Nombre: ");
        String name;
        boolean validName = false;
        do {
            name = readData.next();
            if (validationUtil.ValidateLetterString(name)) {
                validName = true;
            } else {
                System.out.println("El nombre solo debe contener letras. Por favor, ingrese un nombre válido.");
            }
        } while (!validName);

        System.out.print("Edad: ");
        int age = 0;
        boolean validAge = false;
        do {
            String ageInput = readData.next();
            if (validationUtil.validateInt(ageInput)) {
                age = validationUtil.getInt(ageInput);
                validAge = true;
            } else {
                System.out.println("La edad debe ser un número entero. Por favor, ingrese una edad válida.");
            }
        } while (!validAge);

        String contactNumber;
        boolean validContactNumber = false;
        do {
            System.out.print("Numero telefonico: ");
            contactNumber = readData.next();
            if (!validationUtil.ValidateNumberString(contactNumber)) {
                System.out.println("El número de contacto solo debe contener dígitos numéricos.");
            } else {
                validContactNumber = true;
            }
        } while (!validContactNumber);

        administrator = new Administrator(id, name, age, contactNumber);

        File archivo = new File("data\\administrator.json");
        if (archivo.exists() && archivo.length() == 0) {
            listAdministrator = new ArrayList<>();
        } else {
            listAdministrator = editAdministratorData.readAdministratorData();
        }

        listAdministrator.add(administrator);
        editAdministratorData.writeEmployeeData(listAdministrator);
    }
}
