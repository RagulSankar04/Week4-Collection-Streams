
import java.util.Scanner;

public class FinallyBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter the Numerator: ");
            int num = sc.nextInt();

            System.out.println("Enter the Denominator: ");
            int den = sc.nextInt();

            int result = num / den;
            System.out.println("Result: " + result );

        }catch(ArithmeticException e){
            System.out.println("Cannot Divide by Zero");
        }finally{
            System.out.println("Operation Completed");
            sc.close();
        }
    }
}
