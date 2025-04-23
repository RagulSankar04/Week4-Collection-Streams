public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = {6, 10, 15, 20, 60, 100, 500};
        
        // Find the minimum and maximum values
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        // Loop through the array to find min and max
        for (int num : nums) {
            if (num < start) start = num;
            if (num > end) end = num;
        }
        
        // Iterate through the range from start to end
        for (int i = start; i <= end; i++) {
            boolean found = false;
            
            // Check if the current number is in the array
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            
            // If the number is not found, print it
            if (!found) {
                System.out.print(i + " ");
            }
        }
    }
}
