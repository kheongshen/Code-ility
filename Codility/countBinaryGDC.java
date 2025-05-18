public class countBinaryGDC {
    // This is a simple Java program to count the number of 1's in the binary representation of the sum of two integers A and B.
    // The program uses bitwise operations to achieve this.

    // Main method to run the program
    public static void main(String[] args) {
        int result = countBinGDC(12,18);
        System.out.println(result);
    }

     public static int countBinGDC(int A, int B) {
        // Calculate sum of A and B
        int gcd = gcdRecursive(A,B);
        
        // Initialize counter for ones
        int count = Integer.bitCount(gcd);
        
        return count;
    }
    
    public static int gcdRecursive(int a, int b) {
    if (b == 0) {
        return Math.abs(a);
    }
    return gcdRecursive(b, a % b);
    }
}