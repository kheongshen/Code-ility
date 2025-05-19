import java.util.HashSet;
import java.util.Set;

public class DivisibleBy {

    public static int countDivisibleBy3Variants(String S) {
        Set<String> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            char original = S.charAt(i);
            for (char d = '0'; d <= '9'; d++) {
                if (d == original) continue;

                // Replace character at position i with d
                StringBuilder modified = new StringBuilder(S);
                modified.setCharAt(i, d);
                String newStr = modified.toString();

                // Skip leading zero cases
                if (newStr.length() > 1 && newStr.charAt(0) == '0') continue;

                // Check if already tried this number
                if (seen.contains(newStr)) continue;
                seen.add(newStr);

                // Check if the modified number is divisible by 3
                int digitSum = 0;
                for (char c : newStr.toCharArray()) {
                    digitSum += (c - '0');
                }
                if (digitSum % 3 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        String S = "300";
        System.out.println(countDivisibleBy3Variants(S)); // Output: 4
    }
}
