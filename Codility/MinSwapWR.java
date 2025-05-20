public class MinSwapWR {

    /**
     * Calculates the minimum number of swaps required to group 'W's and 'R's together in a string.
     *
     * @param s The input string containing 'W' and 'R' characters.
     * @return The minimum number of swaps required.
     */
    public static int minSwaps(String s) {
        if (s == null || s.length() <= 1) {
            return 0; // No swaps needed for null, empty, or single-character strings
        }

        int n = s.length();
        int countW = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'W') {
                countW++;
            }
        }

        // Two possible arrangements: Ws followed by Rs, or Rs followed by Ws.
        // We calculate the swaps needed for both arrangements and choose the minimum.

        int swapsWR = calculateSwaps(s, 'W'); // Ws followed by Rs
        int swapsRW = calculateSwaps(s, 'R'); // Rs followed by Ws

        return Math.min(swapsWR, swapsRW);
    }

    /**
     * Calculates the number of swaps needed to arrange the string such that all instances of `target` character
     * come first.
     *
     * @param s      The input string.
     * @param target The character we want to group at the beginning of the string ('W' or 'R').
     * @return The number of swaps needed.
     */
    private static int calculateSwaps(String s, char target) {
        int n = s.length();
        int swaps = 0;
        int wrongPosition = 0;  // Counts how many characters *not* equal to `target` are in the desired initial position.

        for (int i = 0; i < countTarget(s, target); i++) {
            if (s.charAt(i) != target) {
                wrongPosition++;
            }
        }
        swaps = wrongPosition;  // Each incorrect character requires a swap.

        return swaps;
    }
    /**
     * Counts the number of occurrences of a specific character in a string.
     *
     * @param s      The input string.
     * @param target The character to count.
     * @return The number of times the character appears in the string.
     */
    private static int countTarget(String s, char target) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String s1 = "WRRWWR";
        System.out.println("Minimum swaps for " + s1 + ": " + minSwaps(s1)); // Expected output: 1

        String s2 = "WWRWWWRWR";
        System.out.println("Minimum swaps for " + s2 + ": " + minSwaps(s2)); // Expected output: 1

        String s3 = "RRRRWWWW";
        System.out.println("Minimum swaps for " + s3 + ": " + minSwaps(s3)); // Expected output: 0

        String s4 = "WWWW";
        System.out.println("Minimum swaps for " + s4 + ": " + minSwaps(s4)); // Expected output: 0

        String s5 = "RRRR";
        System.out.println("Minimum swaps for " + s5 + ": " + minSwaps(s5)); // Expected output: 0

        String s6 = "WRW";
        System.out.println("Minimum swaps for " + s6 + ": " + minSwaps(s6)); // Expected output: 1

        String s7 = "RWW";
        System.out.println("Minimum swaps for " + s7 + ": " + minSwaps(s7)); // Expected output: 0

        String s8 = "WR";
        System.out.println("Minimum swaps for " + s8 + ": " + minSwaps(s8)); // Expected output: 0

        String s9 = "W";
        System.out.println("Minimum swaps for " + s9 + ": " + minSwaps(s9)); // Expected output: 0

        String s10 = "";
        System.out.println("Minimum swaps for " + s10 + ": " + minSwaps(s10)); // Expected output: 0

        String s11 = "WWWRRR";
        System.out.println("Minimum swaps for " + s11 + ": " + minSwaps(s11));  //Expected output 0
    }
}