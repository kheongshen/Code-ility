import java.util.*;

public class BiValuedSliced {

    public static int longestBiValuedSlice(int[] A) {
        int maxLen = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < A.length; right++) {
            countMap.put(A[right], countMap.getOrDefault(A[right], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(A[left], countMap.get(A[left]) - 1);
                if (countMap.get(A[left]) == 0) {
                    countMap.remove(A[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Example usage
    public static void main(String[] args) {
        int[] A = {4, 5, 5, 4, 2, 4, 5};
        System.out.println(longestBiValuedSlice(A)); // Output: 4 (slice [4,5,5,4])
        System.out.println(longestBiValuedSlice(new int[]{7,7,8,8,8,9}));
    }
}
