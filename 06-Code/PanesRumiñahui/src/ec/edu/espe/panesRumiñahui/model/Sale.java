package ec.edu.espe.panesrumiñahui.model;
/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Sale {

    private double totalSales;
    

    public Sale(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "\n\tGanancias Diarias:" + "\n\t\tGanancia del Dia=" + getTotalSales();
    }
    


    
}