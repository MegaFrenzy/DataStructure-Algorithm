package dynamicprogram2;

import java.util.Arrays;

/**
 * lintCode108.Given a string s, cut s into some substrings
 * such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 输入: "aab"    输出: 1
 * 解释: 将 "aab" 分割一次, 得到 "aa" 和 "b", 它们都是回文串.
 */
public class S2_PalindromeCut {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int len = s.length;
        boolean[][] isPalin = calcPalin(s);
        //dp[i]表示前i长度的字符串切为回文串的最小分割次数
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len] - 1;
    }

    /**
     * @param s 要计算的回文字符串
     * @return 从索引i到j是否为回文串的布尔值
     */
    private static boolean[][] calcPalin(char[] s) {

        int len = s.length;
        boolean[][] f = new boolean[len][len];
        int l, r;
        //根据对称字符判断奇数长度的回文串
        for (int c = 0; c < len; c++) {
            l = r = c;
            while (l >= 0 && r < len && s[l] == s[r]) {
                f[l][r] = true;
                l--;
                r++;
            }
        }
        //根据对称轴判断偶数长度的回文串
        for (int c = 0; c < len - 1; c++) {
            l = c;
            r = c + 1;
            while (l >= 0 && r < len && s[l] == s[r]) {
                f[l][r] = true;
                l--;
                r++;
            }
        }

        return f;
    }
}
