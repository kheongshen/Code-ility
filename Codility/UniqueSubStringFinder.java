public class UniqueSubStringFinder {

    public static String shortestUniqueSubstringLength(String S) {
        int n = S.length();

        for (int len = 1; len <= n; len++) {  //<-- update len to 3 if min characters is 3
            // Use a simple frequency map via string keys
            java.util.HashMap<String, Integer> freqMap = new java.util.HashMap<>();

            for (int i = 0; i <= n - len; i++) {
                String sub = S.substring(i, i + len);
                freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
            }

            for (int i = 0; i <= n - len; i++) {
                String sub = S.substring(i, i + len);
                if (freqMap.get(sub) == 1) {
                    return sub; // Return the first unique substring of this minimal length
                }
            }
        }

        return ""; // all substrings occur more than once
    }

    public static void main(String[] args) {
        System.out.println(shortestUniqueSubstringLength("abac"));    // Output: 1 (e.g., 'b' or 'c')
        System.out.println(shortestUniqueSubstringLength("aaaa"));   // Output: 4 (only "aaaa" is unique)
        System.out.println(shortestUniqueSubstringLength("abcabc")); // Output: 3 (e.g., "cab" or "bca")
        System.out.println(shortestUniqueSubstringLength("xxyyzzy")); 
        System.out.println(shortestUniqueSubstringLength("abcabcabcde")); 
    }
}