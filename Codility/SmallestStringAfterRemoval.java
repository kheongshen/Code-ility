public class SmallestStringAfterRemoval {

    public static String removeOneCharForSmallest(String S) {
        int N = S.length();

        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) > S.charAt(i + 1)) {
                return S.substring(0, i) + S.substring(i + 1);
            }
        }

        // If no such character found, remove the last one
        return S.substring(0, N - 1);
    }

    public static void main(String[] args) {
        System.out.println(removeOneCharForSmallest("abcde")); // abcd
        System.out.println(removeOneCharForSmallest("abdc"));  // abc
        System.out.println(removeOneCharForSmallest("cbabc")); // babc
        System.out.println(removeOneCharForSmallest("hot"));     // (empty string)
        System.out.println(removeOneCharForSmallest("codility"));

    }
}

