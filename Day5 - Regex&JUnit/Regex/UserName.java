import java.util.Scanner;

public class UserName {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        boolean isValid = userName.matches(regex);
        System.out.println("Is the UserName Valid ? " + isValid);
        sc.close();
    }
}