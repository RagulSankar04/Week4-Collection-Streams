import java.util.*;
import java.util.regex.*;

public class RepeatingWords {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1).toLowerCase());
        }

        System.out.println("Repeating Words: " + String.join(", ", repeatingWords));

        sc.close();
    }
}
