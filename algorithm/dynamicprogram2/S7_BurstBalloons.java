package dynamicprogram2;

/**
 * lintCode168.有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。
 * 每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
 * left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。
 * 要求吹爆所有气球，得到最多的分数。0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 你可以假设nums[-1] = nums[n] = 1。-1和n位置上的气球不真实存在，因此不能吹爆它们。
 * <p>
 * 样例 1:
 * 输入：[4, 1, 5, 10]     输出：270
 * 解释：
 * nums = [4, 1, 5, 10] 吹爆 1, 得分 4 * 1 * 5 = 20
 * nums = [4, 5, 10]   吹爆 5, 得分 4 * 5 * 10 = 200
 * nums = [4, 10]   吹爆 4, 得分 1 * 4 * 10 = 40
 * nums = [10]   吹爆 10, 得分 1 * 10 * 1 = 10
 * 总得分 20 + 200 + 40 + 10 = 270
 * <p>
 * 样例 2:
 * 输入：[3,1,5]       输出：35
 * 解释：
 * nums = [3, 1, 5] 吹爆 1, 得分 3 * 1 * 5 = 15
 * nums = [3, 5] 吹爆 3, 得分 1 * 3 * 5 = 15
 * nums = [5] 吹爆 5, 得分 1 * 5 * 1 = 5
 * 总得分 15 + 15 + 5  = 35
 */
public class S7_BurstBalloons {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{4, 1, 5, 10}));
    }

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int origLen = nums.length;
        int[] A = new int[origLen + 2];
        A[0] = A[origLen + 1] = 1;//左右两侧有不能破坏的气球
        for (int i = 0; i < origLen; i++) {
            A[i + 1] = nums[i];
        }
        int n = origLen + 2;
        //dp[i][j]表示破坏索引i+1~j-1气球后得到的收益
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = 0;
        }
        int j = 0;
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n-1];

    }
}
