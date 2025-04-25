import java.util.*;
import java.util.regex.*;

public class ExtractProgrammingLanguages {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String[] languages = { "Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "Rust" };

        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> foundLanguages = new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }

        System.out.println("Programming Languages Found: ");
        for (String lang : foundLanguages) {
            System.out.println(lang);
        }
        sc.close();

    }
}
