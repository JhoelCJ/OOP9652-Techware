package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Product {
    private int id;
    private String nameProduct;
    private float budgetProduct;
    private int stock;

    public Product(int id, String nameProduct, float budgetProduct, int stock) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.budgetProduct = budgetProduct;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameProduct=" + nameProduct + ", budgetProduct=" + budgetProduct + ", stock=" + stock + '}';
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
     * @return the nameProduct
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * @param nameProduct the nameProduct to set
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * @return the budgetProduct
     */
    public float getBudgetProduct() {
        return budgetProduct;
    }

    /**
     * @param budgetProduct the budgetProduct to set
     */
    public void setBudgetProduct(float budgetProduct) {
        this.budgetProduct = budgetProduct;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
