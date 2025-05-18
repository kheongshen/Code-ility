public class evenDigits {
   public static int countEvenDigits(int A) {
        int count = 0;

        // Loop through each digit
        while (A > 0) {
            int digit = A % 10; // Extract the last digit
            if (digit % 2 == 0) { // Check if it's even
                count++;
            }
            A /= 10; // Remove the last digit
        }

        return count;
    }

    public static void main(String[] args) {
        int A = 2048;
        int result = countEvenDigits(A);
        System.out.println("Number of even digits: " + result); // Output should be 3
    }
}
