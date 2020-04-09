package dynamicprogram2;


public class S4_PickStone {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(coins1Answer(i));
            System.out.printf("有%d个石子，先手能赢吗?%b%n", i, coin1(i));
        }
    }

    /**
     * lintCode.394:There are n coins in a line.
     * Two players take turns to take one or two coins from right side until there are no more coins left.
     * The player who take the last coin wins.
     * Could you please decide the first player will win or lose?
     * If the first player wins, return true, otherwise return false.
     * Example 1:   Input: 1    Output: true
     * Example 2:   Input: 4   Output: true
     * Explanation:The first player takes 1 coin at first. Then there are 3 coins left.
     * Whether the second player takes 1 coin or two, then the first player can take all coin(s) left.
     */
    public static boolean coin1(int n) {
        if (n == 0) {
            return false;
        }
        //dp[i]表示有i个石子时先手必胜的布尔值
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 2];
        }
        return dp[n];
    }

    public static boolean coins1Answer(int n) {
        return n % 3 != 0;
    }

    /**
     * lintCode.395:有 n 个不同价值的硬币排成一条线。
     * 两个参赛者轮流从 左边 依次拿走 1 或 2 个硬币，直到没有硬币为止。
     * 计算两个人分别拿到的硬币总价值，价值高的人获胜。
     * 若必胜, 返回 true, 否则返回 false.
     */

    public static boolean coins2(int[] values) {
        if (values.length < 3) {
            return true;
        }
        int n = values.length;
        //dp[i]表示先手从索引i拿硬币的最大值
        int[] dp = new int[n];
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 2] + dp[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = values[i] + Math.max(-dp[i + 1], values[i + 1] - dp[i + 2]);
        }
        return dp[0] >= 0;
    }

    /**
     * lintCode.396:只能从左边或者右边拿第一个，两方都用最优策略，问先手是否必胜
     */
    public static boolean coins3(int[] values) {
        if (values.length <= 3) {
            return true;
        }
        int n = values.length;
        int j;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
