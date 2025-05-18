public class greaterThan {
    public static int countDigitsGreaterThanFive(int number) {
        int count = 0;
        for (char c : String.valueOf(number).toCharArray()) {
            int digit = c - '0';
            if (digit > 5) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 8675309;
        System.out.println("Digits greater than 5: " + countDigitsGreaterThanFive(number)); // Output: 3 (8, 6, 7)
    }
}
