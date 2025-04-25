
import java.util.Scanner;

public class HexCode {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Hex Color Code: ");
        String hexCode = sc.nextLine();

        String regex = "^#[0-9a-fA-F]{6}$";

        boolean isValid = hexCode.matches(regex);

        System.out.println("Is it valid HexCode ?" + isValid);

    }
}
