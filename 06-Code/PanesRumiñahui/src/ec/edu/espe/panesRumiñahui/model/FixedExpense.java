package ec.edu.espe.panesrumiñahui.model;

/**
 *
 * @author Diego Casignia, Techware, DCCO-ESPE
 */
public class FixedExpense {
    String argument;
    float amount;

    @Override
    public String toString() {
        return "\tAsunto: " + argument + "\n\tMonto: " + amount;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public FixedExpense(String argument, float amount) {
        this.argument = argument;
        this.amount = amount;
    }
}
