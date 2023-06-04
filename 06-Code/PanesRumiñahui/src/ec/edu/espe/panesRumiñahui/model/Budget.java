package ec.edu.espe.panesRumiñahui.model;

import java.util.Scanner;

/**
 * @author Gabriel Calvache
 * @author Gabriel Baez
 * @author Jilmar Calderon
 */
public class Budget {

    private double budgetGeneral;
    private double budgetSalary;
    private double budgetBuy;
    Scanner scanner = new Scanner(System.in);

    public void budget() {
        
        do {
            System.out.println("\nIngrese el Presupuesto Mensual: ");

            budgetGeneral = scanner.nextDouble();
            if (budgetGeneral < 0) {
                System.out.println("Ese valor de Prosupuesto no es valido");
            }
        } while (budgetGeneral < 0);

    }

    public double salary() {

        budgetSalary = 500;//budgetGeneral * 0.2;
        budgetGeneral = budgetGeneral - budgetSalary;
      
        System.out.println("\nEl pago a los empleados es de: " + budgetSalary);
        return budgetSalary;
    }

    public void buy() {

        String product;
        double productPrice;
        double totalBuy;
       
        budgetBuy = budgetGeneral * 0.36;
        budgetGeneral = budgetGeneral - budgetBuy;
        
        System.out.println("\nIngrese el precio del producto: ");
        productPrice= scanner.nextDouble();
        
        totalBuy= budgetBuy-productPrice;
        totalBuy=totalBuy*taxes();
        
        budgetBuy=budgetBuy-totalBuy;
        
    }
    
    public double taxes() {
        
        double printTaxes= 12;
        double taxes = 0.12;
        System.out.println("\nEl iva es de: "+printTaxes+"%");
        return taxes;
    }
}
