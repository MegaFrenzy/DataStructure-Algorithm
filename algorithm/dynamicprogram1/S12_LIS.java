package dynamicprogram1;

import java.util.Arrays;

/**
 * lintCode76.最长上升子序列Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * <p>
 * LIS:The longest increasing subsequence problem is to find a subsequence of a given sequence
 * in which the subsequence's elements are in sorted order, lowest to highest,
 * and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * Example 1:
 * Input:  [5,4,1,2,3]     Output:  3
 * Explanation:LIS is [1,2,3]
 * <p>
 * Example 2:
 * Input: [4,2,4,5,3,7]    Output:  4
 * Explanation: LIS is [2,4,5,7]
 */
public class S12_LIS {
    public static void main(String[] args) {
//        System.out.println(getLength(new int[]{5, 4, 1, 2, 3}));
        System.out.println(printSequence(new int[]{4, 2, 4, 5, 3, 7}));
    }

    public static int getLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        //dp[i]表示以索引i结尾的非连续递增数组的最大长度
        int[] dp = new int[A.length];
        dp[0] = 1;
        for (int i = 1; i < A.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int printSequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int maxLen = 0;
        int index = 0;
//        int count=0;
        int[] rec = new int[n];
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    rec[i] = j;
                }
            }
            if (f[i] > maxLen) {
                maxLen = f[i];
                index = i;//记下所求数组的最大索引值
//                count++;
            }
        }
        int[] seq = new int[maxLen];
        for (int i = maxLen - 1; i >= 0; i--) {
            seq[i] = A[index];
            index = rec[index];
        }
        System.out.println(Arrays.toString(seq));
        return maxLen;
    }
}
