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
        public void readAdministrator() throws FileNotFoundException{
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        File archivo = new File("administrator.json");
        ArrayList<Administrator> listAdministrator = new ArrayList();
        System.out.println("\t\t\t\tAdministrator List");
        
        if (archivo.exists() && archivo.length() == 0) {
            System.out.println("No hay Administradores\n\n");
        } else {
            listAdministrator = editAdministratorData.readAdministratorData();
            for(Administrator administrator : listAdministrator){
                System.out.println(administrator.toString());
            }
        }
    }
    
    public void createAdministrator() throws FileNotFoundException{
        EditAdministratorData editAdministratorData = new EditAdministratorData();
        ArrayList<Administrator> listAdministrator = new ArrayList();
        Administrator administrator;
        Scanner readData = new Scanner(System.in);
        System.out.print("Id: ");
        int id = readData.nextInt();
        System.out.print("Nombre: ");
        String name = readData.next();
        System.out.print("Edad: ");
        int age = readData.nextInt();
        System.out.print("Numero telefonico: ");
        String contactNumber = readData.next();
        administrator = new Administrator(id, name, age, contactNumber);
        
        File archivo = new File("administrator.json");
        if (archivo.exists() && archivo.length() == 0) {
            listAdministrator = new ArrayList<>();
        } else {
            listAdministrator = editAdministratorData.readAdministratorData();
        }
        
        listAdministrator.add(administrator);
        editAdministratorData.writeEmployeeData(listAdministrator);
    }
}
