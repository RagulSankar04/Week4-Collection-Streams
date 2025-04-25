import java.util.Scanner;

public class ReplaceBadWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String[] badWords = { "damn", "stupid" };

        String censored = input;

        for (String word : badWords) {
            censored = censored.replaceAll("(?i)\\b" + word + "\\b", "*****");
        }
        System.out.println("Censored Words: ");
        System.out.println(censored);

    }
}
