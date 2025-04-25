import java.util.Scanner;
import java.util.regex.*;

public class ExtractLinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text");
        String input = sc.nextLine();

        String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Links Extracted: " + matcher.group());
        }
        sc.close();
    }
}
