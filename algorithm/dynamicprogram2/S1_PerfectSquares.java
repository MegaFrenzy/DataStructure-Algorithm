package dynamicprogram2;

import java.util.Arrays;

/**
 * 给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
 * Example 1:   Input: 12   Output: 3
 * Explanation: 4 + 4 + 4
 * Example 2:   Input: 13   Output: 2
 * Explanation: 4 + 9
 */
public class S1_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(squaresNum(25));
    }

    public static int squaresNum(int n) {
        if (n == 1) {
            return 1;
        }
        //dp[i]表示数字i由完全平方数所组成的最小个数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
