package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditEmployeeData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyEmployee {

    public void readEmployee() throws FileNotFoundException {
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        File archivo = new File("data\\employee.json");
        ArrayList<Employee> listEmployees = new ArrayList<>();
        System.out.println("\t\t\t\tEmployed List");

        try {
            if (archivo.exists() && archivo.length() == 0) {
                System.out.println("No hay empleados\n\n");
            } else {
                listEmployees = editEmployeeData.readEmployeeData();
                for (Employee employee : listEmployees) {
                    System.out.println(employee.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public void createEmployee() throws FileNotFoundException {
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        ArrayList<Employee> listEmployees = new ArrayList();
        Employee employee;
        Scanner readData = new Scanner(System.in);
        ValidationUtil validationUtil = new ValidationUtil();

        int id = 0;
        boolean continueValidation = true;
        while (continueValidation) {
            System.out.print("\nId: ");
            String idString = readData.nextLine();
            if (validationUtil.ValidateLetterString(idString)) {
                continueValidation = false;
                id = validationUtil.getInt(idString);
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

        int year = 0;
        continueValidation = true;
        while (continueValidation) {
            System.out.print("Anio que empezo a trabajar: ");
            String yearString = readData.nextLine();
            if (validationUtil.ValidateLetterString(yearString)) {
                continueValidation = false;
                year = validationUtil.getInt(yearString);
            } else {
                System.out.println("Dato Invalido");
            }
        }

        int month = 0;
        continueValidation = true;
        while (continueValidation) {
            System.out.print("Mes que empezo a trabajar: ");
            String yearString = readData.nextLine();
            if (validationUtil.ValidateLetterString(yearString)) {
                continueValidation = false;
                month = validationUtil.getInt(yearString);
            } else {
                System.out.println("Dato Invalido");
            }
        }

        int day = 0;
        continueValidation = true;
        while (continueValidation) {
            System.out.print("Dia que empezo a trabajar: ");
            String dayString = readData.nextLine();
            if (validationUtil.ValidateLetterString(dayString)) {
                continueValidation = false;
                day = validationUtil.getInt(dayString);
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

        employee = new Employee(id, name, age, new Date(year - 1900, month - 1, day), contactNumber);

        File archivo = new File("data\\employee.json");
        if (archivo.exists() && archivo.length() == 0) {
            listEmployees = new ArrayList<>();
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
        }

        listEmployees.add(employee);
        editEmployeeData.writeEmployeeData(listEmployees);
    }

    public void deleteEmployee() throws FileNotFoundException {
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        File archivo = new File("data\\employee.json");
        ArrayList<Employee> listEmployees = new ArrayList();
        ValidationUtil validationUtil = new ValidationUtil();

        try {
            if (archivo.exists() && archivo.length() == 0) {
                System.out.println("No hay empleados\n\n");
            } else {
                listEmployees = editEmployeeData.readEmployeeData();
                Scanner readData = new Scanner(System.in);
                String name = null;
                boolean continueValidation = true;
                while (continueValidation) {
                    System.out.print("Nombre del empleado a eliminar: ");
                    name = readData.nextLine();
                    if (validationUtil.ValidateLetterString(name)) {
                        continueValidation = false;
                    } else {
                        System.out.println("Dato Invalido");
                    }
                }

                for (int i = 0; i < listEmployees.size(); i++) {
                    Employee employee = listEmployees.get(i);
                    if (employee.getName().equals(name)) {
                        listEmployees.remove(i);
                        editEmployeeData.writeEmployeeData(listEmployees);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
