
public class UniqueConcat {

    public static int maxLength(String[] A) {
        return backtrack(A, 0, "");
    }

    private static int backtrack(String[] A, int index, String current) {
        if (!isUnique(current)) return 0;

        int maxLen = current.length();

        for (int i = index; i < A.length; i++) {
            maxLen = Math.max(maxLen, backtrack(A, i + 1, current + A[i]));
        }

        return maxLen;
    }

    // Checks if all characters in the string are unique
    private static boolean isUnique(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx]) return false;
            seen[idx] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(new String[]{"un", "iq", "ue"}));     // Output: 4 ("uniq" or "ique")
        System.out.println(maxLength(new String[]{"cha","r","act","ers"})); // Output: 6 ("chaers")
        System.out.println(maxLength(new String[]{"aa", "bb"}));            // Output: 0 (no valid concat)
        System.out.println(maxLength(new String[]{"co","dil","ity"})); 
        System.out.println(maxLength(new String[]{"potato","kayak","banana","racecar"})); 
    }
}