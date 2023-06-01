package ec.edu.espe.panesrumiñahui.model;


/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 * @author Baez Gabriel, Techware, DCCO-ESPE
 */

public class Administrator {
    private int id;
    private String name;
    private int age;
    private String contactNumber;

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", name=" 
                + name + ", age=" + age + ", contactNumber=" + contactNumber + '}';
    }

    public Administrator(int id, String name, int age, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
