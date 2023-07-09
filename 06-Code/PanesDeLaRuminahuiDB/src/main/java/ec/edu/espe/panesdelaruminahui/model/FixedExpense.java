/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.panesdelaruminahui.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class FixedExpense {
    private String argument;
    private float amount;

    public FixedExpense(String argument, float amount) {
        this.argument = argument;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FixedExpense{" + "argument=" + argument + ", amount=" + amount + '}';
    }
    
    
    /**
     * @return the argument
     */
    public String getArgument() {
        return argument;
    }

    /**
     * @param argument the argument to set
     */
    public void setArgument(String argument) {
        this.argument = argument;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
