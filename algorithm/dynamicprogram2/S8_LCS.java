package dynamicprogram2;

import java.util.Arrays;

/**
 * lintCode77.最长公共子序列Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * Example 1:
 * Input:  "ABCD" and "EDCA"   Output:  1
 * Explanation:    LCS is 'A' or  'D' or 'C'
 * <p>
 * Example 2:
 * Input: "ABCD" and "EACB"        Output:  2
 * Explanation:    LCS is "AC"
 */

public class S8_LCS {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("JavaExE", "vax"));
    }

    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        char[] s1 = A.toCharArray();
        int m = s1.length;
        char[] s2 = B.toCharArray();
        int n = s2.length;

        int[][] sign = new int[m + 1][n + 1];
        //dp[i][j]表示A串前i个字符与B串前j个字符的公共子序列最大值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                sign[i][j] = dp[i][j] == dp[i - 1][j] ? 1 : 2;
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    sign[i][j] = dp[i][j] == dp[i - 1][j - 1] + 1 ? 3 : sign[i][j];
                }
            }
        }
        char[] track = new char[dp[m][n]];
        int trackIdx = dp[m][n] - 1;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            switch (sign[i][j]){
                case 1:
                    i--;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    track[trackIdx--]=s1[i-1];
                    i--;
                    j--;
            }
        }
        System.out.println(Arrays.toString(track));

        return dp[m][n];
    }
}
