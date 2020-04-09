package dynamicprogram2;

/**
 * lintCode.29:判断s3是否由s1和s2交叉构成
 * Given three strings: s1, s2, s3, determine whether
 * s3 is formed by the interleaving of s1 and s2.
 * Input:"aabcc" "dbbca" "aadbbcbcac"
 * Output:  true
 */
public class S9_InterleavingStr {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String str1, String str2, String str3) {
        if (str1 == null || str2 == null || str3 == null) {
            throw new RuntimeException("empty string");
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] s3 = str3.toCharArray();
        int m = s1.length, n = s2.length;
        if (m + n != s3.length) {
            return false;
        }
        //dp[i][j]表示s1前i个和s2前j个能否组成s3前i+j个
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i > 0 && s3[i + j - 1] == s1[i - 1]) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j > 0 && s3[i + j - 1] == s2[j - 1]) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
