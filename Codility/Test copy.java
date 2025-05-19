public class Test {
    public int[] solution(String R, int[] V) {
        int minBalanceA = 0;
        int minBalanceB = 0;
        int currentA = 0;
        int currentB = 0;

        for (int i = 0; i < R.length(); i++) {
            if (R.charAt(i) == 'A') {
                currentB -= V[i];
                currentA += V[i];
                minBalanceB = Math.min(minBalanceB, currentB);
            } else {
                currentA -= V[i];
                currentB += V[i];
                minBalanceA = Math.min(minBalanceA, currentA);
            }
        }

        return new int[]{Math.abs(minBalanceA), Math.abs(minBalanceB)};
    }

    public static void main(String[] args) {
        Test test = new Test();
        String R = "BAABA";
        int[] V = {2, 4, 1, 1, 2};
        int[] result = test.solution(R, V);
        System.out.println("Minimum balances: A=" + result[0] + ", B=" + result[1]);  // Output: [2, 4]
    }
}
