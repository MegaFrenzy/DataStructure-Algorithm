package dynamicprogram1;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * You can only go right or down in the path..
 * <p>
 * Example 1:
 * Input:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Output: 7
 * <p>
 * Explanation: Path is: 1 -> 3 -> 1 -> 1 -> 1
 */
public class S8_MinPathSum {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr1 = {{1, 2}, {1, 1}};
//        滚动数组
//        System.out.println(slidingArray(arr));
//        System.out.println(slidingArray(arr1));
        //扩展：顺序打印出所走的路径的值
        System.out.println(minPathSumPrint(arr));
        System.out.println(minPathSumPrint(arr1));
    }

    public static int slidingArray(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        //滚动数组
        int[][] f = new int[2][n];
        int old = 0, now = 0;
        for (int i = 0; i < m; i++) {
            //每处理新的一行时，交换old now
            old = now;
            now = 1 - now;
            for (int j = 0; j < n; j++) {
                f[now][j] = Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    f[now][j] = A[i][j];
                    continue;
                }
                if (i > 0) {
                    f[now][j] = Math.min(f[now][j], A[i][j] + f[old][j]);
                }
                if (j > 0) {
                    f[now][j] = Math.min(f[now][j], A[i][j] + f[now][j - 1]);
                }
            }
        }
        return f[now][n - 1];
    }

    public static int minPathSumPrint(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];
        //建立数组记录轨迹
        int[][] recTrack = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = A[i][j];
                    continue;
                }
                f[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j]);
                    if (f[i][j] == f[i - 1][j]) {
                        recTrack[i][j] = 1;
                    }
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i][j - 1]);
                    if (f[i][j] == f[i][j - 1]) {
                        recTrack[i][j] = 2;
                    }
                }
                f[i][j] += A[i][j];
            }
        }

        int[] path = new int[m + n - 1];
        path[0] = A[0][0];
        int x = m - 1, y = n - 1, p = m + n - 2;
        for (int i = p; i > 0; i--) {
            switch (recTrack[x][y]){
                case 1:
                    path[i]=A[x--][y];
                    break;
                case 2:
                    path[i]=A[x][y--];
                    break;
                default:
                    break;
            }
        }
        System.out.println(Arrays.toString(path));

        return f[m - 1][n - 1];

    }

    public static int minPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    f[i][j] = A[i][j];
                    continue;
                }
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], A[i][j] + f[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.min(f[i][j], A[i][j] + f[i][j - 1]);
                }
//                循环内内容
//                if (i == 0 && j > 0) {
//                    f[i][j] = A[i][j] + f[i][j - 1];
//                } else if (j == 0 && i > 0) {
//                    f[i][j] = A[i][j] + f[i - 1][j];
//                } else if (i > 0) {
//                    f[i][j] = A[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
//                }
            }
        }
        return f[m - 1][n - 1];
    }
}
