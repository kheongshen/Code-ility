import java.util.HashSet;
import java.util.Set;

public class DistinctSlices {

    public static int countDistinctSlices(int[] A) {
        int N = A.length;
        Set<Integer> seen = new HashSet<>();
        int front = 0, total = 0;

        for (int back = 0; back < N; back++) {
            while (seen.contains(A[back])) {
                seen.remove(A[front]);
                front++;
            }
            seen.add(A[back]);
            total += (back - front + 1);
        }

        return total;
    }

    // Example usage
    public static void main(String[] args) {
        int[] A = {3, 4, 5, 5, 2};
        System.out.println(countDistinctSlices(A)); // Output: 11
    }
}
