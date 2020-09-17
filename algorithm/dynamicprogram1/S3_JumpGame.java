package dynamicprogram1;

/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 */
public class S3_JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,0,4};
        //arr = new int[]{0};
        System.out.println(jumpGame(arr));
    }


    public static boolean jumpGame(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        boolean[] dp = new boolean[len];

        dp[0] = true;
        for (int i = 1; i < len; i++) {

            dp[i] = false;
            for (int p = i - 1; p >= 0; p--) {
                if (dp[p] && p + nums[p] >= i) { //dp[p]可达，并在该位置可跳到dp[i]
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
