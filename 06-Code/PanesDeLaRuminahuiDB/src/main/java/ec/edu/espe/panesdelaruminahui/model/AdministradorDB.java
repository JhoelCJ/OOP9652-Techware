
package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class AdministradorDB {

    private int id;
    private String name;
    private int age;
    private String contactNumber;

    public AdministradorDB(int id, String name, int age, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "AdministradorDB{" + "id=" + id + ", name=" + name + ", age=" + age + ", contactNumber=" + contactNumber + '}';
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
 
}
