package dynamicprogram2;


/**
 * lintCode.437:Given n books and the i-th book has pages[i] pages.
 * There are k persons to copy these books.
 * These books list in a row and each person can claim a continuous range of books.
 * For example, one copier can copy the books from i-th to j-th continuously,
 * but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 * They start copying books at the same time and they all cost 1 minute to copy 1 page of a book.
 * What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 * Return the shortest time that the slowest copier spends.
 * <p>
 * Example 1:
 * Input: pages = [3, 2, 4], k = 2      Output: 5
 * Explanation:
 * First person spends 5 minutes to copy book 1 and book 2.
 * Second person spends 4 minutes to copy book 3.
 * Example 2:
 * Input: pages = [3, 2, 4], k = 3      Output: 4
 * Explanation: Each person copies one of the books.
 */
public class S3_CopyBooks {
    public static void main(String[] args) {
        System.out.println(myCopyBooks(new int[]{3, 2, 4}, 3));
        System.out.println(myCopyBooks(new int[]{3, 2, 4}, 2));
        System.out.println(answer(new int[]{3, 2, 4}, 3));
        System.out.println(answer(new int[]{3, 2, 4}, 2));
    }

    public static int myCopyBooks(int[] pages, int K) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int n = pages.length;
        //书比人少则返回最多的页数
        if (K >= n) {
            int max = pages[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, pages[i]);
            }
            return max;
        }
        int[] partSum = new int[n];
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += pages[i];
            partSum[i] = tmp;
        }
        //dp[k][j]表示前k个人完成前j本书时所消耗的最小时间
        int[][] dp = new int[K + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int k = 1; k <= K; k++) {
            dp[k][0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[k][i] = Integer.MAX_VALUE;
                for (int j = 0; j <= i; j++) {
                    if (j > 0) {
                        dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - 1][j], partSum[i - 1] - partSum[j - 1]));
                    } else {
                        dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - 1][j], partSum[i - 1]));
                    }
                }
            }
        }
        return dp[K][n];
    }

    public static int answer(int[] pages, int K) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int n = pages.length;
        if (K > n) {
            K = n;
        }

        int[][] f = new int[K + 1][n + 1];
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }
        for (int k = 1; k <= K; k++) {
            f[k][0] = 0;
            for (int i = 1; i <= n; i++) {
                int lastPersonTask = 0;
                f[k][i] = Integer.MAX_VALUE;
                //从后往前进行加和可减少一次循环或采用myCopyBooks中的部分和
                for (int j = i; j >= 0; j--) {
                    f[k][i] = Math.min(f[k][i], Math.max(f[k - 1][j], lastPersonTask));
                    if (j > 0) {
                        lastPersonTask += pages[j - 1];
                    }
                }
            }
        }
        return f[K][n];
    }
}
