class Solution {
    public int countBinaryOnes(int A, int B) {
        // Calculate sum of A and B
        int sum = A + B;
        
        // Initialize counter for ones
        int count = Integer.bitCount(sum);
        
        // while (sum > 0) {
        // if ((sum & 1) == 1) {
        //     count++;
        // }
        // sum = sum >>> 1;
        // }
        
        return count;
    }
}

public class countBinaryOnes {
    // This is a simple Java program to count the number of 1's in the binary representation of the sum of two integers A and B.
    // The program uses bitwise operations to achieve this.

    // Main method to run the program
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBinaryOnes(100000, 0)); // Example usage
    }
}