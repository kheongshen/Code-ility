public class MinDeletionsForABFormat {

    public static int minDeletions(String S) {
        int N = S.length();
        int[] suffixA = new int[N + 1]; // Number of A's from i to end

        // Count total number of A's from right to left
        for (int i = N - 1; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + (S.charAt(i) == 'A' ? 1 : 0);
        }

        int minDeletions = suffixA[0]; // Case: delete all A's (only B's left)
        int countB = 0;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'B') countB++;
            // Minimum deletions: B's before i + A's after i
            minDeletions = Math.min(minDeletions, countB + suffixA[i + 1]);
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("BAAABAB")); // Output: 2
        System.out.println(minDeletions("ABAB"));    // Output: 1
        System.out.println(minDeletions("BBBB"));    // Output: 0
        System.out.println(minDeletions("AAAA"));    // Output: 0
    }
}
