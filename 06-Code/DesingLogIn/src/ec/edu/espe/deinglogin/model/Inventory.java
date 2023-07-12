package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Inventory {
    private int id;
    private String Name;
    private int amount;
    private float price;

    public Inventory(int id, String Name, int amount, float price) {
        this.id = id;
        this.Name = Name;
        this.amount = amount;
        this.price = price;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
