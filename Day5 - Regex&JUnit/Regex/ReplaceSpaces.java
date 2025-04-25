import java.util.Scanner;

public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Text: ");
        String input = sc.nextLine();

        String replacedText = input.replaceAll("\\s+", " ");

        System.out.println("Original: " + input);
        System.out.println("Formatted: " + replacedText);

    }
}
