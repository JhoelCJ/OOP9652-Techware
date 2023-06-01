package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditEmployeeData;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class ModifyEmployee {
    
    public void readEmployee() throws FileNotFoundException{
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        editEmployeeData.readEmployeeData();
        
    }
    
    public void createEmployee(){
        EditEmployeeData editEmployeeData = new EditEmployeeData();
        Employee employee;
        ArrayList<Employee> employee1 = new ArrayList<>();
        Scanner readData = new Scanner(System.in);
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("Name: ");
        String name = readData.next();
        System.out.print("Age: ");
        int age = readData.nextInt();
        System.out.print("Year start work: ");
        int year = readData.nextInt();
        System.out.print("Month start work: ");
        int month = readData.nextInt();
        System.out.print("Day start work: ");
        int day = readData.nextInt();
        System.out.print("Phone Number: ");
        String contactNumber = readData.next();
        employee = new Employee(id, name, new GregorianCalendar(year,month,day),  contactNumber);
        employee1.add(employee);
        editEmployeeData.writeEmployeeData(employee);
    }
    
    public void editEmployee(){
        
    }
    
    public void deleteEmployee(){
        
    }
    
}
