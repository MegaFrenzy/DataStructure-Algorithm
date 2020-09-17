package dynamicprogram1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Give a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both
 * the width and height of one envelope is greater than the width and height of the other envelope.
 * Find the maximum number of nested layers of envelopes.
 * <p>
 * Example 1:
 * Input：[[5,4],[6,4],[6,7],[2,3]]    Output：3
 * Explanation：   the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Example 2:
 * Input：[[4,5],[4,6],[6,7],[2,3],[1,1]]  Output：4
 * Explanation：the maximum number of envelopes is 4 ([1,1] => [2,3] => [4,5] / [4,6] => [6,7]).
 */
public class S13_RussianDollEnvelope {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int res = 1;
        int n = envelopes.length;
        //按照从小到大排序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        //dp[i]表示以索引i结尾的信封数量
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
