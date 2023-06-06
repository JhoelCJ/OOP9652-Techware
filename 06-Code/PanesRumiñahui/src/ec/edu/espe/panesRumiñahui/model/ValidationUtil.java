package ec.edu.espe.panesrumiñahui.model;

/**
 *
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class ValidationUtil {

    public boolean validateInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public int getInt(String input) {
        return Integer.parseInt(input);
    }

    public boolean ValidateNumberString(String input) {
        return input.matches("^[0-9]+$");
    }

    public boolean ValidateLetterString(String input) {
        return input.matches("^[a-zA-Z]+$");
    }
}
