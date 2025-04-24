import java.util.Scanner;

public class NestedBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 10, 20, 30, 40, 50 };

        try {
            System.out.println("Enter Array Index: ");
            int index = sc.nextInt();

            try {
                int value = arr[index];

                System.out.println("Enter the divisor: ");
                int divisor = sc.nextInt();

                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by Zero!!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Array Index");
        } finally {
            sc.close();
        }
    }
}
