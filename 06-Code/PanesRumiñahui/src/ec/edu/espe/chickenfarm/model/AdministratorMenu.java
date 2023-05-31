package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class AdministratorMenu{
    
    Scanner scanner = new Scanner(System.in);
    int option;

    System.out.println ("1. View employee");
    System.out.println ("2. Modify employee");
    System.out.println ("3. View inventory");
    System.out.println ("4. Modify inventory");
    System.out.println ("5. View Sales");
    System.out.println ("6. View Daily Report");
    System.out.println ("7. Extit");
            
        do {
            option = Scanner.nextInt();
        if (Option < 1 || option > 7) {
            System.out.println("Invalid Option, please select number again between 1 and 7");
        }

    }
    while(option< 1 || option >7);
            
    switch (option) {
        
        case 1:
            
            break;
        case 2:
            
            break;

        case 3:
            
            break;

        case 4:
            
            break;
        case 5:
            
            break;
        case 6:
            
            break;

        case 7:
            
            break;

        default:
            System.out.println("Invalid option, enter again: ");
    }
            
}
