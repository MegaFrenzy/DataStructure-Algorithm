package dp;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-14 17:03
 */
public class LeetCode53 {

    //53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
        }
        //res不能写0(或 dp[0])，在dp结果均为负时会出错。如input:[-2]，output:0不为预期值-2
        int res = dp[1];
        for (int i = 1; i <= len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
