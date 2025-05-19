public class LongestStringGenerator {

    public static String buildLongestString(int aa, int ab, int bb) {
        StringBuilder result = new StringBuilder();

        while (aa > 0 || ab > 0 || bb > 0) {
            boolean added = false;
            String end = result.length() >= 2 ? result.substring(result.length() - 2) : result.toString();

            // Priority order: use whichever block won't cause aaa or bbb
            if (canAdd(result, "aa") && aa > 0) {
                result.append("aa");
                aa--;
                added = true;
            } else if (canAdd(result, "bb") && bb > 0) {
                result.append("bb");
                bb--;
                added = true;
            } else if (canAdd(result, "ab") && ab > 0) {
                result.append("ab");
                ab--;
                added = true;
            }

            // If none could be safely added, break
            if (!added) break;
        }

        return result.toString();
    }

    // Helper function to check if adding a block will create "aaa" or "bbb"
    private static boolean canAdd(StringBuilder sb, String block) {
        int len = sb.length();
        String last = sb.toString();

        // Simulate adding the block
        String candidate = last + block;

        // Check last 3 characters for "aaa" or "bbb"
        for (int i = Math.max(0, candidate.length() - 3); i <= candidate.length() - 3; i++) {
            String sub = candidate.substring(i, i + 3);
            if (sub.equals("aaa") || sub.equals("bbb")) {
                return false;
            }
        }
        return true;
    }

    public static String buildLongestStringSimple(int aa, int ab, int bb) {
        StringBuilder result = new StringBuilder();

        while (true) {
            String last = result.length() >= 2 ? result.substring(result.length() - 2) : "";

            // Try to add a block in a safe order
            if (aa > 0 && !last.equals("aa")) {
                result.append("aa");
                aa--;
            } else if (bb > 0 && !last.equals("bb")) {
                result.append("bb");
                bb--;
            } else if (ab > 0) {
                result.append("ab");
                ab--;
            } else {
                break; // No valid block can be added
            }

            // Prevent "aaa" or "bbb" from forming
            int len = result.length();
            if (len >= 3) {
                String tail = result.substring(len - 3);
                if (tail.equals("aaa") || tail.equals("bbb")) {
                    // Remove last block (2 chars)
                    result.delete(len - 2, len);
                    // Restore count
                    if (tail.equals("aaa")) aa++;
                    else if (tail.equals("bbb")) bb++;
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(buildLongestString(1, 2, 1));  // Example
    }
}