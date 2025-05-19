import java.util.HashSet;
import java.util.Set;

public class countSuccessfulMoves {

    public static int countSuccessfulMoves(String S) {
        int N = S.length();
        Set<Integer> occupied = new HashSet<>();
        for (int i = 0; i < N; i++) {
            occupied.add(i); // All fields initially occupied by one player each
        }

        int successCount = 0;

        for (int i = 0; i < N; i++) {
            char direction = S.charAt(i);
            int target = -1;

            if (direction == '<') {
                target = i - 1;
            } else if (direction == '>') {
                target = i + 1;
            } else {
                continue; // ^ or v, no move attempted
            }

            // Check if target is valid and unoccupied
            if (target >= 0 && target < N && !occupied.contains(target)) {
                occupied.remove(i);      // player leaves current field
                occupied.add(target);   // player occupies new field
                successCount++;
            }
        }

        return successCount;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(countSuccessfulMoves(">><<")); // Output: 2
        System.out.println(countSuccessfulMoves("<<>>")); // Output: 0
        System.out.println(countSuccessfulMoves(">^<v")); // Output: 2
    }
}
