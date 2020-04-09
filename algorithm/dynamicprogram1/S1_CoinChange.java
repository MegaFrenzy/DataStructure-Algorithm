package dynamicprogram1;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class S1_CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int minNum = coinChange(coins, 11);
        System.out.println(minNum);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        //initialization
        f[0] = 0;
        //calc f[1],f[2]...f[amount]
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            //f[i]=min{f[i-coins[0]]+1,f[i-coins[1]]+1...}
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        return (f[amount] == Integer.MAX_VALUE) ? -1 : f[amount];
    }
    /**
     * 1.确定状态
     *  最后一步（最优策略中使用的最后一枚硬币
     *  化成子问题（最少的硬币拼出更小的面值amount-coin[x]
     * 2.转移方程
     *  f[i]=min{f[i-2]+1,f[i-5]+1，f[i-7]+1}
     * 3.初始条件和边界情况
     *  f[0]=0,不能拼出=正无穷
     * 4.顺序计算
     *  f[0],f[1],f[2]
     */
}
