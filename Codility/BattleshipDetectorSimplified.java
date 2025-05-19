public class BattleshipDetectorSimplified {

    public static int[] countShips(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int patrol = 0, submarine = 0, destroyer = 0;

        // All L-shaped submarine patterns
        int[][][] L_SHAPES = {
            {{0,0},{1,0},{1,1}}, {{0,0},{1,0},{1,-1}},
            {{0,0},{0,1},{1,1}}, {{0,0},{0,1},{-1,1}},
            {{0,0},{-1,0},{-1,1}}, {{0,0},{-1,0},{-1,-1}},
            {{0,0},{0,-1},{-1,-1}}, {{0,0},{0,-1},{1,-1}}
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visited[r][c] || board[r][c] == '.') continue;

                // Try destroyer (horizontal/vertical line of 3)
                if (checkShip(board, visited, r, c, new int[][]{{0,0},{0,1},{0,2}})) {
                    mark(board, visited, r, c, new int[][]{{0,0},{0,1},{0,2}});
                    destroyer++;
                } else if (checkShip(board, visited, r, c, new int[][]{{0,0},{1,0},{2,0}})) {
                    mark(board, visited, r, c, new int[][]{{0,0},{1,0},{2,0}});
                    destroyer++;
                }

                // Try patrol (line of 2)
                else if (checkShip(board, visited, r, c, new int[][]{{0,0},{0,1}})) {
                    mark(board, visited, r, c, new int[][]{{0,0},{0,1}});
                    patrol++;
                } else if (checkShip(board, visited, r, c, new int[][]{{0,0},{1,0}})) {
                    mark(board, visited, r, c, new int[][]{{0,0},{1,0}});
                    patrol++;
                }

                // Try submarines (L-shapes)
                else {
                    boolean matched = false;
                    for (int[][] shape : L_SHAPES) {
                        if (checkShip(board, visited, r, c, shape)) {
                            mark(board, visited, r, c, shape);
                            submarine++;
                            matched = true;
                            break;
                        }
                    }
                    if (!matched) visited[r][c] = true; // mark lone cell as visited
                }
            }
        }

        return new int[]{patrol, submarine, destroyer};
    }

    private static boolean checkShip(char[][] board, boolean[][] visited, int r, int c, int[][] shape) {
        for (int[] offset : shape) {
            int nr = r + offset[0], nc = c + offset[1];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) return false;
            if (visited[nr][nc] || (board[nr][nc] != '#' && board[nr][nc] != 'x')) return false;
        }
        return true;
    }

    private static void mark(char[][] board, boolean[][] visited, int r, int c, int[][] shape) {
        for (int[] offset : shape) {
            visited[r + offset[0]][c + offset[1]] = true;
        }
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
