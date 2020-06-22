package dynamicprogram1;


import java.util.Arrays;

public class S7_Subsequence {
    public static void main(String[] args) {
        //最长连续递增子序列的长度，要求升序降序中取最大
        System.out.println(myContinuousLength(new int[]{4, 1, 2, 5, 3, 6, 7, 8}));//4
        printSubArray(new int[]{5, 4, 2, 1, 3});
    }

    /**
     * 最长连续递增子序列
     * LintCode Longest Increasing Continuous Subsequence
     * Give an integer array，
     * find the longest increasing continuous subsequence in this array.
     * An increasing continuous subsequence:
     * Can be from right to left or from left to right.
     * Indices of the integers in the subsequence should be continuous.
     * Notice:O(n) time and O(1) extra space.
     * <p>
     * Example
     * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
     * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
     */
    public static int myContinuousLength(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int recLen = 0;
        int maxLen = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                maxLen++;
            } else {
                recLen = Math.max(maxLen, recLen);
                maxLen = 1;
            }
        }
        recLen = Math.max(maxLen, recLen);
        maxLen = 1;
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i - 1] > A[i]) {
                maxLen++;
            } else {
                recLen = Math.max(maxLen, recLen);
                maxLen = 1;
            }
        }

        return Math.max(maxLen, recLen);
    }

    public static int answerCL(int[] A) {
        int n;
        if ((n = A.length) == 0) {
            return 0;
        }
        int r1 = LIS(A, n);
        //反转数组
        int i = 0, j = n - 1, t;
        while (i < j) {
            t = A[i];
            A[i] = A[j];
            A[j] = t;
            i++;
            j--;
        }
        int r2 = LIS(A, n);
        return Math.max(r1, r2);
    }

    private static int LIS(int[] A, int n) {
        int[] f = new int[n];
        int res = 0;
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            if (A[i - 1] < A[i]) {
                f[i] = f[i - 1] + 1;
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }

    public static void printSubArray(int[] A) {
        if (A.length == 0) {
            return;
        }
        int recLen = 0;
        int maxLen = 1;
        int maxPosition = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                maxLen++;
            } else {
                if (maxLen > recLen) {
                    maxPosition = i - 1;
                }
                recLen = Math.max(maxLen, recLen);
                maxLen = 1;
            }
        }
        if (maxLen > recLen) {
            maxPosition = A.length - 1;
        }
        recLen = Math.max(maxLen, recLen);
        for (int i = maxPosition - maxLen + 1; i <= maxPosition; i++) {
            System.out.print(A[i] + "  ");
        }
        System.out.println();
//        maxLen = 1;
//        for (int i = A.length - 1; i >= 1; i--) {
//            if (A[i - 1] > A[i]) {
//                maxLen++;
//            } else {
//                recLen = Math.max(maxLen, recLen);
//                maxLen = 1;
//            }
//        }
    }



}