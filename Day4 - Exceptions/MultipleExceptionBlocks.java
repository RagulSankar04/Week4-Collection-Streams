
import java.util.Scanner;

public class MultipleExceptionBlocks {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = { 1, 2, 3, 4, 5 };

        System.out.print("Enter an index to retrieve the element: ");
        int index = sc.nextInt();

        try {
            System.out.println("Value at index " + index + ": " + input[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is out of bounds.");
        } catch (NullPointerException e) {
            System.out.println("Error: The array is null.");
        }

        sc.close();
    }
}
