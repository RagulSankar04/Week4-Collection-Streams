import java.util.Scanner;

public class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String zeroTo255 = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d?|0)";
        String regex = "^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$";

        boolean isValid = input.matches(regex);
        System.out.println("Is it Valid? " + isValid);
    }
}
