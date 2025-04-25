import java.util.Scanner;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Card Number: ");
        String input = sc.nextLine();

        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";

        if (input.matches(visaRegex)) {
            System.out.println("Valid Visa Card");
        } else if (input.matches(masterRegex)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid Credit Card Number");
        }

    }
}
