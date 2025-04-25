
import java.util.Scanner;

public class LicensePlateNumber {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Licence Plate Number: ");
        String LicencePlateNumber = sc.nextLine();

        String regex = "^[A-Z]{2}[0-9]{4}$";

        boolean isValid = LicencePlateNumber.matches(regex);

        System.out.println("Is the Number Valid ?  " + isValid);

        sc.close();
    }
}
