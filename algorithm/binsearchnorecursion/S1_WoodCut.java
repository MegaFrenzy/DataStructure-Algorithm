package binsearchnorecursion;

/**
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 * 木头长度的单位是厘米。原木的长度都是正整数，要求切割得到的小段木头的长度也要求是整数。
 * 无法切出要求至少 k 段的,则返回 0 即可。
 * Given n pieces of wood with length L[i] (integer array).
 * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
 * What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.
 * 样例 1
 * 输入:  L = [232, 124, 456]     k = 7
 * 输出: 114
 * Explanation: 我们可以把它分成114cm的7段，而115cm不可以
 * <p>
 * 样例 2
 * 输入:   L = [1, 2, 3]  k = 7
 * 输出: 0
 * 说明:很显然我们不能按照题目要求完成。
 */
public class S1_WoodCut {
    public static void main(String[] args) {

    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int maxLen = L[0];
        for (int i = 1; i < L.length; i++) {
            maxLen = Math.max(maxLen, L[i]);
        }
        int lenStart = 1;
        int lenEnd = maxLen;
        int mid = 0;
        while (lenStart + 1 < lenEnd) {
            mid = lenStart + (lenEnd - lenStart) / 2;
            if (getPieces(L, mid) >= k) {
                lenStart = mid;
            } else {
                lenEnd = mid;
            }
        }
        if (getPieces(L, lenStart) >= k) {
            return lenStart;
        }
        if (getPieces(L, lenEnd) >= k) {
            return lenEnd;
        }
        return 0;
    }

    private int getPieces(int[] L, int cutLen) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / cutLen;
        }
        return sum;
    }
}
