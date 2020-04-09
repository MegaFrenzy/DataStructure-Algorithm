package dynamicprogram2;

public class S5_Backpack {
    public static void main(String[] args) {
        System.out.println("-----092-----");
        System.out.println(maxWeightNew(10, new int[]{3, 4, 8, 5}));//用物品拼出最接近且不大于10的重量为9
        System.out.println(maxWeightNew(12, new int[]{2, 3, 5, 7}));//用物品拼出最接近且不大于12的重量为12
        System.out.println(maxWeightNew(12, new int[]{5, 11, 9, 7}));
        System.out.println("-----563-----");//每个数只能用一次
        System.out.println(howManyWays(new int[]{1, 2, 3, 3, 7}, 7));//将数组中的数拼成7有2种办法
        System.out.println(howManyWays(new int[]{1, 1, 1, 1}, 3));//将数组中的数拼成3有4种办法
        System.out.println("-----564-----");//每个数可重复使用
        System.out.println(howManyCombinations(new int[]{1, 2, 4}, 4));//6种方法通过1，2，4组成4
        System.out.println("-----125-----");
        System.out.println(maxValue2(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));//最多装价值9的物品
        System.out.println(maxValue2(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));//最多装价值10的物品
    }

    /**
     * LintCode.92:Given n items with size Ai, an integer m denotes the size of a backpack.
     * How full you can fill this backpack?
     * Example 1:
     * Input:  [3,4,8,5], backpack size=10  Output:  9
     * Example 2:
     * Input:  [2,3,5,7], backpack size=12  Output:  12
     */
    public static int maxWeightNew(int weight, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        //dp[i][j]表示数值i能否用前j个数拼成的布尔值
        boolean[][] used = new boolean[weight + 1][n + 1];
        boolean[][] dp = new boolean[weight + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int w = 1; w <= weight; w++) {
            dp[w][0] = false;
            for (int i = 1; i <= n; i++) {
                dp[w][i] = dp[w][i - 1];
                if (w >= A[i - 1]) {
                    dp[w][i] = dp[w][i] || dp[w - A[i - 1]][i - 1];
                    if (dp[w][i]) {
                        used[w][i] = true;
                    }
                }
            }
        }
        int maxWeight = 0;
        for (int w = weight; w >= 0; w--) {
            if (dp[w][n]) {
                maxWeight = w;
                break;
            }
        }
        int weightCursor = maxWeight;
        System.out.print("组合为 [");
        for (int i = n; i >= 0; i--) {
            if (used[weightCursor][i]) {
                System.out.print(A[i - 1] + " ");
                weightCursor -= A[i - 1];
            }
        }
        System.out.print("] ");
        return maxWeight;
    }

    public static int maxWeightOrig(int w, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        //dp[i][j]表示前i个物品能否拼出重量为j的布尔值
        boolean[][] dp = new boolean[n + 1][w + 1];
        boolean[][] used = new boolean[n + 1][w + 1];
        dp[0][0] = true;
        for (int i = 1; i <= w; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - A[i - 1]];//OR按位或操作
                    if (dp[i - 1][j - A[i - 1]]) {
                        used[i][j] = true;
                    }
                }
            }
        }
        int maxWeight = 0;
        for (int i = w; i >= 0; i--) {
            if (dp[n][i]) {
                maxWeight = i;
                break;
            }
        }
        int weight = maxWeight;
        System.out.print("组合为[");
        for (int j = n; j >= 1; j--) {
            if (used[j][weight]) {
                System.out.print(A[j - 1] + " ");
                weight -= A[j - 1];
            }
        }
        System.out.print("] ");
        return maxWeight;
    }

    /**
     *
     * LintCode.563:能填满背包的方案数，每个物品只能用一次
     * Given n items with size nums[i] which an integer array and all positive numbers.
     * An integer target denotes the size of a backpack.
     * Find the number of possible fill the backpack.
     * Each item may only be used once
     * Given candidate items [1,2,3,3,7] and target 7  Output:2
     * A solution set is:[7],[1, 3, 3]
     */
    public static int howManyWays(int[] A, int w) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int i = 1; i <= w; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            //reverse order
            for (int j = w; j >= 0; j--) {
                if (j >= A[i - 1]) {
                    dp[j] += dp[j - A[i - 1]];
                }
            }
        }
        return dp[w];
//        原始方法
//        //dp[i][j]表示前i个物品拼出重量为j的组合数
//        int[][] dp = new int[n + 1][w + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= w; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= w; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j >= A[i - 1]) {
//                    dp[i][j] += dp[i - 1][j - A[i - 1]];
//                }
//            }
//        }
//        return dp[n][w];
    }

    /**
     * LintCode.564:给出正整数数组可重复使用，找出所有和为 target 的组合数。
     * Given an integer array nums with all positive numbers and no duplicates,
     * find the number of possible combinations that add up to a positive integer target.
     * A number in the array can be used multiple times in the combination.
     * Different orders are counted as different combinations.
     * <p>
     * Input: nums = [1, 2, 4], and target = 4      Output: 6
     * Explanation: The possible combination ways are:[1, 1, 1, 1]/[1, 1, 2]/[1, 2, 1]/[2, 1, 1]/[2, 2]/[4]
     * Input: nums = [1, 2], and target = 4         Output: 5
     * Explanation:The possible combination ways are:[1, 1, 1, 1]/[1, 1, 2]/[1, 2, 1]/[2, 1, 1]/[2, 2]
     */
    public static int howManyCombinations(int[] A, int num) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        //dp[i]表示利用长度为n的数组A拼出数值i的组合数
        int[] dp = new int[num + 1];
        dp[0] = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= A[j]) {
                    dp[i] += dp[i - A[j]];
                }
            }
        }
        return dp[num];
    }

    /**
     * LintCode.125:There are n items and a backpack with size m.
     * Given array A representing the size of each item and array V representing the value of each item.
     * What's the maximum value can you put into the backpack?
     * A[i], V[i], n, m are all integers.Each item can only be picked up once
     * The sum size of the items you want to put into backpack can not exceed m.
     * <p>
     * Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]        Output: 9
     * Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9
     * Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]              Output: 10
     * Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10
     */
    public static int maxValue(int m, int[] A, int[] V) {
        int n = A.length;
        //dp[i][j]表示前i件物品在背包空间为j情况下的最大价值量
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i-1][j - A[i - 1]] + V[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    //如果每个物品都能用无穷次则最大价值时多少
    public static int maxValue2(int m, int[] A, int[] V) {
        int n = A.length;
        //dp[j]表示在背包空间为j情况下的最大价值量
        int[] dp = new int[m + 1];
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j - A[i - 1]] + V[i - 1], dp[j]);
                }
            }
        }
        return dp[m];
//        //dp[i][j]表示前i件物品在背包空间为j情况下的最大价值量
//        int[][] dp = new int[n + 1][m + 1];
//        dp[0][0] = 0;
//        for (int i = 1; i <= m; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j >= A[i - 1]) {
//                    dp[i][j] = Math.max(dp[i][j - A[i - 1]] + V[i - 1], dp[i - 1][j]);
//                }
//            }
//        }
//        return dp[n][m];
    }
}

