import java.util.*;
import java.util.regex.*;

public class ExtractEmail {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text: ");
        String text = sc.nextLine();

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            System.out.println("Extracted Email Address: ");
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("\nNo Email Address found");
        }
        sc.close();
    }
}
