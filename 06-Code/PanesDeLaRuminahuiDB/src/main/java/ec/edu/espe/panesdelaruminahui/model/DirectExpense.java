/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class DirectExpense {
    
    private String invoiceNumber;
    private String name;
    private int amount;
    private float price;

    public DirectExpense(String invoiceNumber, String name, int amount, float price) {
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n\tNo. de Factura: " + invoiceNumber + "\n\tProducto: " + name +
                "\n\tCantidad: " + amount + "\n\tPrecio: " + price;
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
