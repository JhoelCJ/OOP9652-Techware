package ec.edu.espe.panesrumiñahui.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Sale {

    private float totalSales;

    public Sale(float totalSales) {
        this.totalSales = totalSales;
    }

    public float getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(float totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "\n\tGanancias Diarias:" + "\n\t\tGanancia del Dia=" + getTotalSales();
    }

}
