package dynamicprogram1;

/**
 * LintCode.114
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class S2_UniquePathsX2 {
    /**
     * @param m: positive integer (1<=m<=100)
     * @param n: positive integer (1<=m<=100)
     * @return : An integer
     */
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }
    /**
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids.
     * How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * The total number of unique paths is 2.
     */
    public static int uniquePath2(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = 0;
                if (A[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                if (i > 0) {
                    f[i][j] += f[i - 1][j];
                }
                if (j > 0) {
                    f[i][j] += f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }
}
