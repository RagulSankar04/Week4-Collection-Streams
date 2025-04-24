
import java.util.InputMismatchException;
import java.util.Scanner;

public class UnCheckedException {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Numberator: ");
            int numerator = sc.nextInt();

            System.out.println("Enter the Denominator: ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error Cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Error Enter Numeric Value");
        }

    }
}
