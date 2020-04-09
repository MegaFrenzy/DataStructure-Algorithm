package dynamicprogram1;

/**
 * There are a row of n houses,
 * each house can be painted with one of the three colors:red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 */
public class S5_PaintHouseX2 {
    public static void main(String[] args) {
        int[][] A = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(paintHouse(A));
        System.out.println("------");
        int[][] arr0 = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        int[][] arr1 = new int[][]{{1, 2, 3}, {1, 4, 6}};
        int[][] arr2 = new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        System.out.println(paintHouse2(arr2));
    }

    public static int paintHouse(int[][] A){
        int len = A.length;
        int[][] f = new int[len+1][3];
        f[0][0]=f[0][1]=f[0][2]=0;
        for (int i = 1; i <= len; i++) {
            f[i][0]=f[i][1]=f[i][2]=Integer.MAX_VALUE;
            //j:当前房子的颜色
            for (int j = 0; j < 3; j++) {
                //k:前栋房子的颜色
                for (int k = 0; k < 3; k++) {
                    if(j!=k){
                        f[i][j]=Math.min(f[i][j],f[i-1][k]+A[i-1][j]);
                    }
                }
            }
//            f[i][0]=A[i-1][0]+Math.min(f[i-1][1],f[i-1][2]);
//            f[i][1]=A[i-1][1]+Math.min(f[i-1][0],f[i-1][2]);
//            f[i][2]=A[i-1][2]+Math.min(f[i-1][0],f[i-1][1]);
        }

        return Math.min(Math.min(f[len][0],f[len][1]),f[len][2]);
    }
    public static int paintHouse2(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int len = A.length;
        int colorNo = A[0].length;//k表示颜色序号
        int[][] f = new int[len + 1][colorNo];
//        for (int i = 0; i < colorNo; i++) {
//            f[0][i] = 0;
//        }
        int min1, min2, idx1 = 0, idx2 = 0;
        for (int i = 1; i <= len; i++) {
            min1 = min2 = Integer.MAX_VALUE;
            for (int j = 0; j < colorNo; j++) {
                if (f[i - 1][j] < min1) {
                    min2 = min1;
                    //idx2 = idx1;
                    min1 = f[i - 1][j];
                    idx1 = j;
                } else if (f[i - 1][j] < min2) {
                    min2 = f[i - 1][j];
                    //idx2 = j;
                }
            }
            for (int j = 0; j < colorNo; j++) {
                f[i][j] = (j == idx1) ? min2 + A[i - 1][j] : min1 + A[i - 1][j];
            }
        }
        int res = f[len][0];
        for (int i = 1; i < colorNo; i++) {
            res = Math.min(res, f[len][i]);
        }
        return res;
    }

    public static int paintHouse2new(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int len = A.length;
        int colorNo = A[0].length;//k表示颜色序号
        int[][] f = new int[2][colorNo];
        //滚动数组实现
        int old, now = 1;
        int min1, min2, idx1 = 0;
        for (int i = 0; i < len; i++) {
            old = now;
            now = 1 - now;
            min1 = min2 = Integer.MAX_VALUE;
            for (int j = 0; j < colorNo; j++) {
                if (f[old][j] < min1) {
                    min2 = min1;
                    min1 = f[old][j];
                    idx1 = j;
                } else if (f[old][j] < min2) {
                    min2 = f[old][j];
                }
            }
            for (int j = 0; j < colorNo; j++) {
                if (j == idx1) {
                    f[now][j] = min2 + A[i][j];
                } else {
                    f[now][j] = min1 + A[i][j];
                }
            }
        }
        int res = f[now][0];
        for (int i = 1; i < colorNo; i++) {
            res = Math.min(res, f[now][i]);
        }


        return res;
    }

}
