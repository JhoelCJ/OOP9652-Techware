package ec.edu.espe.panesrumiñahui.model;

import ec.edu.espe.panesrumiñahui.controller.EditAdministratorData;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class ModifyAdministrator {
    public void readAdministrator() throws FileNotFoundException{
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        editAdministratorData.readAdministratorData();
        
    }
    
    public void createAdministrator(){
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        Administrator administrator;
        ArrayList<Administrator> administrator1 = new ArrayList<>();
        Scanner readData = new Scanner(System.in);
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("Name: ");
        String name = readData.next();
        System.out.print("Age: ");
        int age = readData.nextInt();
        System.out.print("Phone Number: ");
        String contactNumber = readData.next();
        administrator = new Administrator(id, name, age,  contactNumber);
        administrator1.add(administrator);
        editAdministratorData.writeAdministratorData(administrator);
    }
}
