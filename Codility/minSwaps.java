import java.util.*;

public class minSwaps {
    
    public static int minSwapsForAAAAndBBB(String S) {
        int n = S.length();
        int countA = 0, countB = 0;
        for (char c : S.toCharArray()) {
            if (c == 'a') countA++;
            else if (c == 'b') countB++;
        }

        if (countA < 3 || countB < 3) return -1; // not enough 'a's or 'b's

        String sorted = sortString(S);
        List<String> permutations = generatePermutations(sorted, "aaa", "bbb");

        int minSwaps = Integer.MAX_VALUE;

        for (String target : permutations) {
            int swaps = countAdjacentSwaps(S, target);
            if (swaps != -1) {
                minSwaps = Math.min(minSwaps, swaps);
            }
        }

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // Generate all unique permutations that contain "aaa" and "bbb"
    private static List<String> generatePermutations(String s, String substr1, String substr2) {
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result, substr1, substr2, new HashSet<>());
        return result;
    }

    private static void permute(char[] arr, int index, List<String> result, String substr1, String substr2, Set<String> seen) {
        if (index == arr.length) {
            String candidate = new String(arr);
            if (candidate.contains(substr1) && candidate.contains(substr2) && !seen.contains(candidate)) {
                result.add(candidate);
                seen.add(candidate);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (canSwap(arr, index, i)) {
                swap(arr, index, i);
                permute(arr, index + 1, result, substr1, substr2, seen);
                swap(arr, index, i);
            }
        }
    }

    private static boolean canSwap(char[] arr, int start, int current) {
        for (int i = start; i < current; i++) {
            if (arr[i] == arr[current]) return false;
        }
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Count number of adjacent swaps to convert from src to target
    private static int countAdjacentSwaps(String src, String target) {
        char[] srcArr = src.toCharArray();
        int swaps = 0;

        for (int i = 0; i < target.length(); i++) {
            if (srcArr[i] != target.charAt(i)) {
                int j = i + 1;
                while (j < srcArr.length && srcArr[j] != target.charAt(i)) {
                    j++;
                }
                if (j == srcArr.length) return -1;

                // Move target.charAt(i) to position i by adjacent swaps
                while (j > i) {
                    char temp = srcArr[j];
                    srcArr[j] = srcArr[j - 1];
                    srcArr[j - 1] = temp;
                    swaps++;
                    j--;
                }
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwapsForAAAAndBBB("bbbabaaaab")); // Example output: 4
        System.out.println(minSwapsForAAAAndBBB("aaabbb")); // Output: 0
        System.out.println(minSwapsForAAAAndBBB("aab"));    // Output: -1
    }
}
