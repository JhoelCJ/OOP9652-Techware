package ec.edu.espe.panesrumiñahui.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class DirectExpense {
    String invoiceNumber;
    String name;
    int amount;
    float price;

    @Override
    public String toString() {
        return "\n\tNo. de Factura: " + invoiceNumber + "\n\tProducto: " + name +
                "\n\tCantidad: " + amount + "\n\tPrecio: " + price;
    }

    public DirectExpense(String invoiceNumber, String name, int amount, float price) {
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
