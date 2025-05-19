public class ArrowGame {
    public static int countSuccessfulMoves(String S) {
        int N = S.length();
        int[] targetCounts = new int[N]; // count how many players want to move to each cell
        boolean[] isMoving = new boolean[N]; // mark which players are attempting to move

        // First pass: determine move targets
        for (int i = 0; i < N; i++) {
            char move = S.charAt(i);
            if (move == '<' && i > 0) {
                targetCounts[i - 1]++;
                isMoving[i] = true;
            } else if (move == '>' && i < N - 1) {
                targetCounts[i + 1]++;
                isMoving[i] = true;
            }
        }

        int successfulMoves = 0;

        // Second pass: evaluate success based on exclusive access to target cell
        for (int i = 0; i < N; i++) {
            if (isMoving[i]) {
                char move = S.charAt(i);
                int target = (move == '<') ? i - 1 : i + 1;

                // Success if target cell is only targeted once and not currently occupied by someone not moving
                if (targetCounts[target] == 1 && !isMoving[target]) {
                    successfulMoves++;
                }
            }
        }

        return successfulMoves;
    }
    public static int countSuccessfulMovesWithUpDown(String S, int width) {
        int N = S.length();
        int[] targetCounts = new int[N];
        boolean[] isMoving = new boolean[N];
        // For up/down moves in unlimited space, no additional initialization needed
        // First pass: determine move targets
        for (int i = 0; i < N; i++) {
            char move = S.charAt(i);
            if (move == '<' && i % width > 0) {
                targetCounts[i - 1]++;
                isMoving[i] = true;
            } else if (move == '>' && i % width < width - 1) {
                targetCounts[i + 1]++;
                isMoving[i] = true;
            } else if (move == '^' && i >= width) {
                targetCounts[i - width]++;
                isMoving[i] = true;
            } else if (move == 'v' && i + width < N) {
                targetCounts[i + width]++;
                isMoving[i] = true;
            }
        }
        
        int successfulMoves = 0;
        
        // Second pass: evaluate success
        for (int i = 0; i < N; i++) {
            if (isMoving[i]) {
                char move = S.charAt(i);
                int target;
                if (move == '<') target = i - 1;
                else if (move == '>') target = i + 1;
                else if (move == '^') target = i - width;
                else target = i + width;
                
                if (targetCounts[target] == 1 && !isMoving[target]) {
                    successfulMoves++;
                }
            }
        }
        
        return successfulMoves;
    }


    public static void main(String[] args) {
        String S = "<><<>>";
        System.out.println("Successful moves: " + countSuccessfulMoves(S)); // Expected output depends on the layout
        String S2 = ">^<v";
        System.out.println("Successful moves with up/down: " + countSuccessfulMovesWithUpDown(S2, 10));
    }
}
