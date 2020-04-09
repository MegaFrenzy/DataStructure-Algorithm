package dynamicprogram1;

import java.util.Arrays;

/**
 * 根据给定数字返回整型数组，数组值为对应索引数字的二进制数中1的个数
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example1
 * Input: 5     Output: [0,1,1,2,1,2]
 * Explanation:The binary representation of 0~5 is:000,001,010,011,100,101
 * the count of "1" in each number is: 0,1,1,2,1,2
 * Example2
 * Input: 3     Output: [0,1,1,2]
 */
public class S4_CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public static int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] f = new int[num + 1];
        f[0] = 0;
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
