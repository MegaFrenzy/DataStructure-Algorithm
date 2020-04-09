package dynamicprogram2;

import java.util.Arrays;

public class S6_PalindromeLength {
    public static void main(String[] args) {
        //求最长非连续的回文串的长度
        System.out.println(longestPalindromeSubseq("abcdedc0bxa"));
        //记忆化搜索解决
        System.out.println(new S6_PalindromeLength().memSearch("015654180"));
    }

    /**
     * lintCode667.Given a string s, find the longest palindromic subsequence's length in s.
     * You may assume that the maximum length of s is 1000.
     * Input: "bbbab"   Output: 4
     * Explanation:     One possible longest palindromic subsequence is "bbbb".
     */
    public static int longestPalindromeSubseq(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] s = str.toCharArray();
        int n = s.length;
        if (n == 1) {
            return 1;
        }
        //dp[i][j]表示从索引i到索引j包含的最大回文串长度
        int[][] dp = new int[n][n];
//        int[][] sign = new int[n][n];//1->去掉头1;2->去掉尾1;3->去头1尾1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = s[i - 1] == s[i] ? 2 : 1;
        }
        int j = 0;
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                sign[i][j] = dp[i][j] == dp[i + 1][j] ? 1 : 2;
                if (s[i] == s[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
//                    sign[i][j] = dp[i][j] == dp[i + 1][j - 1] + 2 ? 3 : sign[i][j];
                }
            }
        }
//        char[] track = new char[dp[0][n - 1]];
//        int lo = 0, hi = dp[0][n - 1] - 1;
//        int si = 0, sj = n - 1;
//        while (si <= sj) {
//            if (si == sj) {
//                track[lo] = s[si];
//                break;
//            }
//            if (si + 1 == sj) {
//                track[lo] = s[si];
//                track[hi] = s[sj];
//                break;
//            }
//            switch (sign[si][sj]) {
//                case 1:
//                    si++;
//                    break;
//                case 2:
//                    sj--;
//                    break;
//                case 3:
//                    track[lo++] = s[si++];
//                    track[hi--] = s[sj--];
//                    break;
//            }
//        }
//        System.out.println("最长回文串是:" + Arrays.toString(track));
        return dp[0][n - 1];

    }

    int[][] f = null;
    char[] s = null;
    int n = 0;

    public int memSearch(String str) {
        if (str == null || str.length() == 0)
            return 0;
        s = str.toCharArray();
        n = s.length;
        if (n == 1) {
            return 1;
        }
        f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                f[i][j] = -1;
            }
        }
        compute(0, n - 1);
        return f[0][n - 1];
    }

    private void compute(int i, int j) {
        if (f[i][j] != -1) {
            return;
        }
        if (i == j) {
            f[i][j] = 1;
            return;
        }
        if (i + 1 == j) {
            f[i][j] = (s[i] == s[j]) ? 2 : 1;
            return;
        }
        compute(i + 1, j);
        compute(i, j - 1);
        compute(i + 1, j - 1);
        f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
        if (s[i] == s[j]) {
            f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
        }
    }

}
