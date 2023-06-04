package ec.edu.espe.panesrumiñahui.model;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Employee {
    private int id;
    private String name;
    private int age;
    private Date startWork;
    private String contactNumber;

    @Override
    public String toString() {
        return "\t\t\t\tEmployed List" + "\n\t\t id: " + id + "\n\t\t nombre: " + name + "\n\t\t Edad: " + age  + "\n\t\t Empieza a Trabajar: " + startWork + "\n\t\t Numero de Contacto: " + contactNumber ;
    }

    public Employee(int id, String name, int age, Date startWork, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startWork = startWork;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getStartWork() {
        return startWork;
    }
    
    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
  
}
