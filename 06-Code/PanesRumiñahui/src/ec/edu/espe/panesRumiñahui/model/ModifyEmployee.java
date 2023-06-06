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
    
    public void readEmployee() throws FileNotFoundException{
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        File archivo = new File("data\\employee.json");
        ArrayList<Employee> listEmployees = new ArrayList<>();
        System.out.println("\t\t\t\tEmployed List");
        
        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay empleados\n\n");
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
            for(Employee employee : listEmployees){
                System.out.println(employee.toString());
            }
        }
    }
    
    public void createEmployee() throws FileNotFoundException{
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        ArrayList<Employee> listEmployees = new ArrayList();
        Employee employee;
        Scanner readData = new Scanner(System.in);
        System.out.print("\nId: ");
        int id = readData.nextInt();
        System.out.print("Nombre: ");
        String name = readData.next();
        System.out.print("Edad: ");
        int age = readData.nextInt();
        System.out.print("Anio que empezo atrabajar: ");
        int year = readData.nextInt();
        System.out.print("Mes que empezo atrabajar: ");
        int month = readData.nextInt();
        System.out.print("Dia que empezo atrabajar: ");
        int day = readData.nextInt();
        String contactNumber;
        boolean validContactNumber = false;
        do {
            System.out.print("Numero telefonico: ");
            contactNumber = readData.next();
            String patronNumerico = "^[0-9]+$";
            if (!contactNumber.matches(patronNumerico)) {
                System.out.println("El número de contacto solo debe contener dígitos numéricos.");
            } else {
                validContactNumber = true;
            }
        } while (!validContactNumber);
        
        employee = new Employee(id, name, age, new Date(year-1900,month-1,day),  contactNumber);
        
        File archivo = new File("data\\employee.json");
        if (archivo.exists() && archivo.length() == 0) {
            listEmployees = new ArrayList<>();
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
        }
        
        listEmployees.add(employee);
        editEmployeeData.writeEmployeeData(listEmployees);
    }
    
    public void deleteEmployee() throws FileNotFoundException{
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        File archivo = new File("data\\employee.json");
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
