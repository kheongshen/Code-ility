public class BankTransferBalance {
    
     public static int[] minInitialBalances(String R, int[] V) {
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
        String R = "BAABA";
        int[] V = {2, 4, 1, 1, 2};
        int[] result = minInitialBalances(R, V);
        System.out.println("Minimum balances: A=" + result[0] + ", B=" + result[1]);  // Output: [2, 4]
    }
}
