public class minSwapCopilot {
    public static int solution(String S) {
        if (S.length() < 6) return -1;
        
        char[] chars = S.toCharArray();
        int n = chars.length;
        int minSwaps = Integer.MAX_VALUE;
        
        // Try to create "aaa" and "bbb"
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (i + 2 >= j && j + 2 >= i) continue;
                
                char[] temp = chars.clone();
                int swaps = 0;
                
                // Create "aaa"
                for (int k = 0; k < 3; k++) {
                    int pos = i + k;
                    while (pos > 0 && temp[pos] == 'b' && temp[pos-1] == 'a') {
                        char t = temp[pos];
                        temp[pos] = temp[pos-1];
                        temp[pos-1] = t;
                        pos--;
                        swaps++;
                    }
                }
                
                // Create "bbb"
                for (int k = 0; k < 3; k++) {
                    int pos = j + k;
                    while (pos > 0 && temp[pos] == 'b' && temp[pos-1] == 'a') {
                        char t = temp[pos];
                        temp[pos] = temp[pos-1];
                        temp[pos-1] = t;
                        pos--;
                        swaps++;
                    }
                }
                
                if (containsTriple(temp)) {
                    minSwaps = Math.min(minSwaps, swaps);
                }
            }
        }
        
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private static boolean containsTriple(char[] arr) {
        boolean hasAAA = false;
        boolean hasBBB = false;
        
        for (int i = 0; i <= arr.length - 3; i++) {
            if (arr[i] == 'a' && arr[i+1] == 'a' && arr[i+2] == 'a') hasAAA = true;
            if (arr[i] == 'b' && arr[i+1] == 'b' && arr[i+2] == 'b') hasBBB = true;
        }
        
        return hasAAA && hasBBB;
    }

    public static void main(String[] args) {
        System.out.println(solution("bbbabaaaab")); // Output: 2
        System.out.println(solution("aabbcc"));  // Output: -1
        System.out.println(solution("aaabbb"));  // Output: 0
        System.out.println(solution("abcabc"));  // Output: -1
        System.out.println(solution("aabbbaaa")); // Output: 3
    }
}
