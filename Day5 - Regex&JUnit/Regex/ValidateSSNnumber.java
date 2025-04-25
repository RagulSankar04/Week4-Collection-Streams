import java.util.Scanner;

public class ValidateSSNnumber {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        String ssn = input.replaceAll(".*?(\\d{3}-\\d{2}-\\d{4}).*", "$1");

        if (ssn.matches(regex)) {
            System.out.println(ssn + " is valid");
        } else {
            System.out.println(ssn + " is not valid");
        }
        sc.close();
    }
}
