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
        File archivo = new File("employee.json");
        ArrayList<Employee> listEmployees = new ArrayList();
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
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("\nNombre: ");
        String name = readData.next();
        System.out.print("Edad: ");
        int age = readData.nextInt();
        System.out.print("Anio que empezo atrabajar: ");
        int year = readData.nextInt();
        System.out.print("Mes que empezo atrabajar: ");
        int month = readData.nextInt();
        System.out.print("Dia que empezo atrabajar: ");
        int day = readData.nextInt();
        System.out.print("Numero telefonico: ");
        String contactNumber = readData.next();
        employee = new Employee(id, name, age, new Date(year,month,day),  contactNumber);
        
        File archivo = new File("employee.json");
        if (archivo.exists() && archivo.length() == 0) {
            listEmployees = new ArrayList<>();
        } else {
            listEmployees = editEmployeeData.readEmployeeData();
        }
        
        listEmployees.add(employee);
        editEmployeeData.writeEmployeeData(listEmployees);
    }
    
    public void editEmployee(){
        
    }
    
    public void deleteEmployee(){
        
    }
    
}
