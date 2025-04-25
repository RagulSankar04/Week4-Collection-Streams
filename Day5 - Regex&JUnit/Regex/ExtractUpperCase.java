import java.util.*;
import java.util.regex.*;

public class ExtractUpperCase {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text: ");
        String text = sc.nextLine();

        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        System.out.println("Captiatlized Words: ");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("\n No Capitalized Words");
        }
        sc.close();
    }
}
