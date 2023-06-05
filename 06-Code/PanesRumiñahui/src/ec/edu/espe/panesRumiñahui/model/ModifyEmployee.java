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
        File archivo = new File("employee.json");
        ArrayList<Employee> listEmployees = new ArrayList<>();
        System.out.println("\t\t\t\tEmployed List");

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay empleados\n\n");
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
            for (Employee employee : listEmployees) {
                System.out.println(employee.toString());
            }
        }
    }

    public void createEmployee() throws FileNotFoundException {
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        ArrayList<Employee> listEmployees = new ArrayList();
        Employee employee;
        Scanner readData = new Scanner(System.in);
        ValidationUtil validationUtil = new ValidationUtil();

        // Validating id
        int id = 0;
        boolean validId = false;
        do {
            System.out.print("\nId: ");
            String idInput = readData.next();
            validId = validationUtil.isValidInt(idInput);
            if (validId) {
                id = Integer.parseInt(idInput);
            } else {
                System.out.println("El id debe ser un valor numerico.");
            }
        } while (!validId);

        // Validating name
        String name;
        boolean validName = false;
        do {
            System.out.print("Nombre: ");
            name = readData.next();
            validName = validationUtil.isValidAlphaNumericString(name);
            if (!validName) {
                System.out.println("El nombre solo debe contener letras (mayusculas o minusculas)");
            }
        } while (!validName);

// Validating age
        int age = 0;
        boolean validAge = false;
        do {
            System.out.print("Edad: ");
            String ageInput = readData.next();
            validAge = validationUtil.isValidInt(ageInput);
            if (validAge) {
                age = Integer.parseInt(ageInput);
            } else {
                System.out.println("La edad debe ser un valor numerico.");
            }
        } while (!validAge);

// Validating year
        int year = 0;
        boolean validYear = false;
        do {
            System.out.print("Año que empezó a trabajar: ");
            String yearInput = readData.next();
            validYear = validationUtil.isValidInt(yearInput);
            if (validYear) {
                year = Integer.parseInt(yearInput);
            } else {
                System.out.println("El año debe ser un valor numérico.");
            }
        } while (!validYear);

// Validating month
        int month = 0;
        boolean validMonth = false;
        do {
            System.out.print("Mes que empezó a trabajar: ");
            String monthInput = readData.next();
            validMonth = validationUtil.isValidInt(monthInput);
            if (validMonth) {
                month = Integer.parseInt(monthInput);
            } else {
                System.out.println("El mes debe ser un valor numérico.");
            }
        } while (!validMonth);

// Validating day
        int day = 0;
        boolean validDay = false;
        do {
            System.out.print("Día que empezó a trabajar: ");
            String dayInput = readData.next();
            validDay = validationUtil.isValidInt(dayInput);
            if (validDay) {
                day = Integer.parseInt(dayInput);
            } else {
                System.out.println("El día debe ser un valor numérico.");
            }
        } while (!validDay);

// Validating contact number
        String contactNumber;
        boolean validContactNumber = false;
        do {
            System.out.print("Número telefónico: ");
            contactNumber = readData.next();
            validContactNumber = validationUtil.isValidNumericString(contactNumber);
            if (!validContactNumber) {
                System.out.println("El número de contacto solo debe contener dígitos numéricos.");
            }
        } while (!validContactNumber);

        employee = new Employee(id, name, age, new Date(year - 1900, month - 1, day), contactNumber);

        File archivo = new File("employee.json");
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
        File archivo = new File("employee.json");
        ArrayList<Employee> listEmployees = new ArrayList();

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay empleados\n\n");
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
            Scanner readData = new Scanner(System.in);

            System.out.print("Nombre del empleado a eliminar: ");
            String name = readData.next();

            for (int i = 0; i < listEmployees.size(); i++) {
                Employee employee = listEmployees.get(i);
                if (employee.getName().equals(name)) {
                    listEmployees.remove(i);
                    editEmployeeData.writeEmployeeData(listEmployees);
                    break;
                }
            }
        }
    }
}
