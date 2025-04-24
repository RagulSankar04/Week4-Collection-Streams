public class ThrowVsThrows {
    static double calculateInterest(int principal, int roi, int time) {
        if (principal < 0 || roi < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return (principal * roi * time) / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(10000, 4, 2);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
