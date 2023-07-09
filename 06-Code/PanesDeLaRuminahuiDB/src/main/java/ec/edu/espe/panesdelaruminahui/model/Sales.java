package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Sales {
   private int id;
   private float totalSales;

    @Override
    public String toString() {
        return "Sales{" + "id=" + id + ", totalSales=" + totalSales + '}';
    }


    public Sales(int id, float totalSales) {
        this.id = id;
        this.totalSales = totalSales;
    }
   
    /**
     * @return the totalSales
     */
    public float getTotalSales() {
        return totalSales;
    }

    /**
     * @param totalSales the totalSales to set
     */
    public void setTotalSales(float totalSales) {
        this.totalSales = totalSales;
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
}
