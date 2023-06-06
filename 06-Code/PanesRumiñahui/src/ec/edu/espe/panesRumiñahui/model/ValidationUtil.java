package ec.edu.espe.panesrumiñahui.model;

/**
 *
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class ValidationUtil {

    public boolean isValidInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidNumericString(String input) {
        return input.matches("^[0-9]+$");
    }

    public boolean isValidAlphaNumericString(String input) {
        return input.matches("^[a-zA-Z]+$");
    }
}
