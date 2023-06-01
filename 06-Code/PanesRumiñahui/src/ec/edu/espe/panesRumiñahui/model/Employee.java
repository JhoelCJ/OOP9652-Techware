package ec.edu.espe.panesrumiñahui.model;

import java.util.Calendar;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Employee {
    private int id;
    private String name;
    private int age;
    private Calendar startWork;
    private String contactNumber;

    @Override
    public String toString() {
        return "Employed{" + "id=" + id + ", name=" + name + ", age=" + age  + ", startWork=" + startWork + ", contactNumber=" + contactNumber + '}';
    }

    public Employee(int id, String name, Calendar startWork, String contactNumber) {
        this.id = id;
        this.name = name;
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

    public Calendar getStartWork() {
        return startWork;
    }
    
    public void setStartWork(Calendar startWork) {
        this.startWork = startWork;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
  
}
