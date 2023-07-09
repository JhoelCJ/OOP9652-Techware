
package ec.edu.espe.panesdelaruminahui.model;

import java.util.Date;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private Date startWork;
    private String contactNumber;

    public Employee(int id, String name, int age, Date startWork, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startWork = startWork;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", age=" + age + ", startWork=" + startWork + ", contactNumber=" + contactNumber + '}';
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the startWork
     */
    public Date getStartWork() {
        return startWork;
    }

    /**
     * @param startWork the startWork to set
     */
    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
