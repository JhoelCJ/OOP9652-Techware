package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class RawMaterial {
    private int id;
    private String nameMaterial;
    private float priceProduct;
    private int stock;

    public RawMaterial(int id, String nameMaterial, float priceProduct, int stock) {
        this.id = id;
        this.nameMaterial = nameMaterial;
        this.priceProduct = priceProduct;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "RawMaterial{" + "id=" + id + ", nameMaterial=" + nameMaterial + ", priceProduct=" + priceProduct + ", stock=" + stock + '}';
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
     * @return the nameMaterial
     */
    public String getNameMaterial() {
        return nameMaterial;
    }

    /**
     * @param nameMaterial the nameMaterial to set
     */
    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    /**
     * @return the priceProduct
     */
    public float getPriceProduct() {
        return priceProduct;
    }

    /**
     * @param priceProduct the priceProduct to set
     */
    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
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
