package dynamicprogram1;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column
 * from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * You can only put the bomb at an empty cell.
 * Example1
 * Input:grid =[
 * "0E00",
 * "E0WE",
 * "0E00"
 * ]
 * Output: 3
 * Explanation:Placing a bomb at (1,1) kills 3 enemies
 * Example2
 * Input:grid =[
 * "0E00",
 * "EEWE",
 * "0E00"
 * ]
 * Output: 2
 * Explanation: Placing a bomb at (0,0) or (0,3) or (2,0) or (2,3) kills 2 enemies
 */
public class S9_BombEnemy {
    public static void main(String[] args) {
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        char[][] grid1 = {{'0', 'E'}};
        System.out.println(maxKilledEnemies(grid));
        System.out.println(maxKilledEnemies(grid1));
        System.out.println(answer(grid));
        System.out.println(answer(grid1));
    }

    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public static int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxRes = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    up[i][j] = up[i - 1][j] + 1;
                } else {
                    up[i][j] = up[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    left[i][j] = left[i][j - 1] + 1;
                } else {
                    left[i][j] = left[i][j - 1];
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1) {
                    down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    down[i][j] = down[i + 1][j] + 1;
                } else {
                    down[i][j] = down[i + 1][j];
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    right[i][j] = right[i][j + 1] + 1;
                } else {
                    right[i][j] = right[i][j + 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    //System.out.printf("[%d,%d] up:%d,down:%d,left:%d,right:%d \n", i, j, up[i][j], down[i][j], left[i][j], right[i][j]);
                    maxRes = Math.max(maxRes,
                            up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return maxRes;
    }

    /*
                    if (grid[i][j] == 'W') {
                        up[i][j] = 0;
                        continue;
                    }
                    up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    if (i > 1) {
                        up[i][j] += up[i - 1][j];
                    }
    */
    public static int answer(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxRes = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    left[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) {
                    up[i][j] += up[i - 1][j];
                }
                if (j > 0) {
                    left[i][j] += left[i][j - 1];
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    right[i][j] = 0;
                    continue;
                }
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i < m - 1) {
                    down[i][j] += down[i + 1][j];
                }
                if (j < n - 1) {
                    right[i][j]+=right[i][j + 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    maxRes = Math.max(maxRes,
                            up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return maxRes;
    }
}




