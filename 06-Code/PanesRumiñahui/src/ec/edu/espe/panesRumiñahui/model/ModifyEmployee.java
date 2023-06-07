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
        ArrayList<Employee> listEmployees = new ArrayList<>();
        ValidationUtil validationUtil = new ValidationUtil();
        Employee employee;
        Scanner readData = new Scanner(System.in);

        System.out.print("\nId: ");
        String idInput = readData.nextLine();
        while (!validationUtil.validateInt(idInput)) {
            System.out.println("El id debe ser un valor numerico.");
            System.out.print("Id: ");
            idInput = readData.nextLine();
        }
        int id = validationUtil.getInt(idInput);

        System.out.print("Nombre: ");
        String name = readData.nextLine();
        while (!validationUtil.ValidateLetterString(name)) {
            System.out.println("El nombre debe contener letras.");
            System.out.print("Nombre: ");
            name = readData.nextLine();
        }
        
        System.out.print("Edad: ");
        String ageInput = readData.nextLine();
        while (!validationUtil.validateInt(ageInput)) {
            System.out.println("La edad debe ser un valor numerico entero.");
            System.out.print("Edad: ");
            ageInput = readData.nextLine();
        }
        int age = validationUtil.getInt(ageInput);

        System.out.print("Anio que empezo a trabajar: ");
        String yearInput = readData.nextLine();
        while (!validationUtil.validateInt(yearInput)) {
            System.out.println("El anio debe ser un valor numerico.");
            System.out.print("Anio que empezo a trabajar: ");
            yearInput = readData.nextLine();
        }
        int year = validationUtil.getInt(yearInput);

        System.out.print("Mes que empezo a trabajar: ");
        String monthInput = readData.nextLine();
        while (!validationUtil.validateInt(monthInput)) {
            System.out.println("El mes debe ser un valor numerico.");
            System.out.print("Mes que empezo a trabajar: ");
            monthInput = readData.nextLine();
        }
        int month = validationUtil.getInt(monthInput);

        System.out.print("Dia que empezo a trabajar: ");
        String dayInput = readData.nextLine();
        while (!validationUtil.validateInt(dayInput)) {
            System.out.println("El dia debe ser un valor numerico.");
            System.out.print("Dia que empezo a trabajar: ");
            dayInput = readData.nextLine();
        }
        int day = validationUtil.getInt(dayInput);

        String contactNumber;
        boolean validContactNumber = false;
        do {
            System.out.print("Numero telefonico: ");
            contactNumber = readData.nextLine();
            if (!validationUtil.ValidateNumberString(contactNumber)) {
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

        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay empleados\n\n");
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
            Scanner readData = new Scanner(System.in);

            System.out.print("\nNombre del empleado a eliminar: ");
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
