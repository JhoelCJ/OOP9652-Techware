package ec.edu.espe.panesrumiñahui.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Product {
    private int id;
    private String nameProduct;
    private float budgetProduct;
    private int stock;

    @Override
    public String toString() {
        return "\n\tProducto" + "\n\t\tid: " + id + "\n\t\tNombre del Producto: " 
                + nameProduct + "\n\t\tPrescio producto: " + budgetProduct
                + "\n\t\tStock: " + stock;
    }

    public Product(int id, String nameProduct, float budgetproduct, int stock) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.budgetProduct = budgetproduct;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getBudgetProduct() {
        return budgetProduct;
    }

    public void setBudgetProduct(float budgetProduct) {
        this.budgetProduct = budgetProduct;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
