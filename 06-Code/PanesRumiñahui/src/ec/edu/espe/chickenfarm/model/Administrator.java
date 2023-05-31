
package ec.edu.espe.chickenfarm.model;

import java.util.Calendar;

/**
 *
 * @author Techware, DCCO-ESPE
 */
public class Administrator {
    
    private int id;
    private String name;
    private int age;
    private Calendar bornOnDate;
    private String adress;
    private String contactNumber;

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", name=" 
                + name + ", age=" + age + ", bornOnDate=" + bornOnDate 
                + ", adress=" + adress + ", contactNumber=" + contactNumber + '}';
    }

    public Administrator(int id, String name, Calendar bornOnDate, String adress, String contactNumber) {
        this.id = id;
        this.name = name;
        this.bornOnDate = bornOnDate;
        this.adress = adress;
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

    public Calendar getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Calendar bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    
    
    
    
}
