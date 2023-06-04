package ec.edu.espe.panesrumiñahui.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */

public class Product {
    private int id;
    private String nameProduct;

    @Override
    public String toString() {
        return "\t\tProduct" + "\n\tid: " + id + "\n\tNombre del Producto: " + nameProduct;
    }

    public Product(int id, String nameProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
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
}
