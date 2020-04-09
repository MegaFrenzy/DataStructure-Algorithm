package dynamicprogram1;

/**
 * @Description: lintCode:149,150,151
 * @Author: MegaFrenzy
 * @CreateTime: 2020-04-03 21:11
 */

public class S11_MaxProfitX4 {
    public static void main(String[] args) {
        System.out.printf("%d\n", maxProfit1(new int[]{3, 2, 3, 1, 2}));
        System.out.printf("%d\n", maxProfit1(new int[]{1, 2, 3, 4, 5}));
        System.out.printf("%d\n", maxProfit1(new int[]{5, 4, 3, 2, 1}));
        System.out.println("------2-------");
        System.out.printf("%d\n", maxProfit2(new int[]{2, 1, 2, 0, 1}));
        System.out.printf("%d\n", maxProfit2(new int[]{4, 3, 2, 1}));
        System.out.println("------3--------");
        System.out.printf("%d\n", maxProfit3(new int[]{2, 1}));
        System.out.printf("%d\n", maxProfit3(new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
        System.out.println("------4--------");
        System.out.printf("%d\n", maxProfit4(2,new int[]{4, 4, 6, 1, 1, 4, 2 ,5}));
        System.out.printf("%d\n", maxProfit4(0,new int[]{3, 2, 1}));

    }

    /**
     * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
     * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
     * 输入: [3, 2, 3, 1, 2]  输出: 1   说明：你可以在第三天买入，第四天卖出，利润是 2 - 1 = 1
     * 输入: [1, 2, 3, 4, 5]  输出: 4   说明：你可以在第0天买入，第四天卖出，利润是 5 - 1 = 4
     * 输入: [5, 4, 3, 2, 1]  输出: 0   说明：你可以不进行任何操作然后也得不到任何利润
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //dp[i]表示到第i天时的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return dp[prices.length - 1];
    }

    /**
     * 给定一个数组 prices 表示一支股票每天的价格.
     * 你可以完成任意次数的交易, 不过你不能同时参与多个交易
     * (如果你已经持有这支股票, 在再次购买之前, 你必须先卖掉它)
     * 设计一个算法求出最大的利润.
     * 输入: [2, 1, 2, 0, 1]  输出: 2
     * 解释: 1. 在第 2 天以 1 的价格买入, 然后在第 3 天以 2 的价格卖出, 利润 1
     * 2. 在第 4 天以 0 的价格买入, 然后在第 5 天以 1 的价格卖出, 利润 1
     * 输入: [4, 3, 2, 1]     输出: 0
     * 解释: 不进行任何交易, 利润为0.
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if ((profit = (prices[i] - prices[i - 1])) > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    /**
     * 你最多可以完成两笔交易。
     * 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
     * 输入 : [4,4,6,1,1,4,2,5]   输出 : 6
     * 解释: 不进行任何交易, 利润为0.
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        //dp[i][j]表示第i天时在j状态下的收益
        /**
         * j==0:未买入 j==1:第一次买入后 j==2:第一次卖出后  j==3:第二次买入后  j==4:第二次卖出后
         */
        int[][] dp = new int[len + 1][5];
        dp[0][0] = 0;
        for (int i = 1; i < 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 5; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (i > 1 && j > 0 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }

            }
            for (int j = 1; j < 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        return Math.max(dp[len][0], Math.max(dp[len][2], dp[len][4]));
    }

    public static int maxProfit3my(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len + 1][5];
        dp[0][0] = 0;
        for (int i = 1; i < 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = dp[i - 1][j];
                        break;
                    case 1:
                    case 3:
                        if (i >= 2) {
                            dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1]);
                        }
                        break;
                    case 2:
                    case 4:
                        if (i >= 2) {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return Math.max(dp[len][0], Math.max(dp[len][2], dp[len][4]));
    }

    /**
     * 你最多可以完成 k 笔交易. 问最大的利润是多少?
     *
     * @param K:      An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    /**
     * 输入: k = 2, prices = [4, 4, 6, 1, 1, 4, 2 ,5] 输出: 6
     * 解释: 以 4 买入, 以 6 卖出. 然后再以 1 买入, 以 5 卖出. 利润为 2 + 4 = 6.
     * 输入: k = 1, prices = [3, 2, 1]    输出: 0
     * 解释: 不进行交易
     */
    public static int maxProfit4(int K, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (K > len / 2) {
            return maxProfit2(prices);
        }
        int[][] dp = new int[2][2 * K + 1];
        int old, now = 1;
        dp[0][0] = 0;
        for (int i = 1; i < 2 * K + 1; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < 2 * K + 1; j += 2) {
                dp[now][j] = dp[old][j];
                if (i > 1 && j > 0 && dp[old][j - 1] != Integer.MIN_VALUE) {
                    dp[now][j] = Math.max(dp[now][j], dp[old][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 1; j < 2 * K + 1; j += 2) {
                dp[now][j] = dp[old][j - 1];
                if (i > 1 && dp[old][j] != Integer.MIN_VALUE) {
                    dp[now][j] = Math.max(dp[now][j], dp[old][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < 2 * K + 1; i += 2) {
            res = Math.max(res, dp[now][i]);
        }
        return res;
    }
}
