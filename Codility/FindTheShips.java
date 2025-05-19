public class FindTheShips {

    public static int[] countShips(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int patrol = 0, submarine = 0, destroyer = 0;

        // Directions for L-shape submarines
        int[][][] submarineShapes = {
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{0,1},{-1,1}},
            {{0,0},{-1,0},{-1,1}},
            {{0,0},{-1,0},{-1,-1}},
            {{0,0},{0,-1},{-1,-1}},
            {{0,0},{0,-1},{1,-1}},
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visited[r][c] || board[r][c] == '.') continue;

                // Check for destroyer
                if (c + 2 < cols &&
                    isShip(board, visited, r, c, r, c + 1, r, c + 2)) {
                    destroyer++;
                    markVisited(visited, r, c, r, c + 1, r, c + 2);
                } else if (r + 2 < rows &&
                    isShip(board, visited, r, c, r + 1, c, r + 2, c)) {
                    destroyer++;
                    markVisited(visited, r, c, r + 1, c, r + 2, c);
                }

                // Check for patrol boat
                else if (c + 1 < cols &&
                    isShip(board, visited, r, c, r, c + 1)) {
                    patrol++;
                    markVisited(visited, r, c, r, c + 1);
                } else if (r + 1 < rows &&
                    isShip(board, visited, r, c, r + 1, c)) {
                    patrol++;
                    markVisited(visited, r, c, r + 1, c);
                }

                // Check for submarine (L-shape)
                else {
                    boolean isSub = false;
                    for (int[][] shape : submarineShapes) {
                        if (isSubmarine(board, visited, r, c, shape)) {
                            submarine++;
                            markVisited(visited, r + shape[0][0], c + shape[0][1],
                                        r + shape[1][0], c + shape[1][1],
                                        r + shape[2][0], c + shape[2][1]);
                            isSub = true;
                            break;
                        }
                    }
                    if (!isSub) visited[r][c] = true; // mark stray piece
                }
            }
        }

        return new int[]{patrol, submarine, destroyer};
    }

    private static boolean isShip(char[][] board, boolean[][] visited, int... coords) {
        for (int i = 0; i < coords.length; i += 2) {
            int r = coords[i], c = coords[i + 1];
            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
            if (visited[r][c]) return false;
            if (board[r][c] != '#' && board[r][c] != 'x') return false;
        }
        return true;
    }

    private static void markVisited(boolean[][] visited, int... coords) {
        for (int i = 0; i < coords.length; i += 2) {
            visited[coords[i]][coords[i + 1]] = true;
        }
    }

    private static boolean isSubmarine(char[][] board, boolean[][] visited, int r, int c, int[][] shape) {
        for (int[] delta : shape) {
            int nr = r + delta[0], nc = c + delta[1];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) return false;
            if (visited[nr][nc]) return false;
            if (board[nr][nc] != '#' && board[nr][nc] != 'x') return false;
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        char[][] board = {
            {'.', '#', '#', '.', '.', '.', '.'},
            {'.', '.', '#', '.', '#', '#', '.'},
            {'.', '.', '.', '.', '#', '.', '.'},
            {'#', '.', '.', '.', '.', '.', '.'}
        };

        int[] result = countShips(board);
        System.out.println("Patrol: " + result[0]);
        System.out.println("Submarine: " + result[1]);
        System.out.println("Destroyer: " + result[2]);
    }
}
