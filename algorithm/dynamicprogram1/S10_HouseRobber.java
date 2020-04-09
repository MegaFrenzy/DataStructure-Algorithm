package dynamicprogram1;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Input: [5, 2, 1, 3]  Output: 8
 * Explanation: Rob the first and the last house.
 */
public class S10_HouseRobber {
    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{5, 2, 1, 3}));
        System.out.println(houseRobber(new int[]{3, 9, 4}));
        //滚动变量
        System.out.println(houseRobber0(new int[]{5, 2, 1, 3}));
        System.out.println(houseRobber0(new int[]{3, 9, 4}));
    }

    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public static long houseRobber(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        long[] f = new long[A.length + 1];
        f[0] = 0;
        f[1] = A[0];
        for (int i = 2; i <= A.length; i++) {
            f[i] = Math.max(f[i - 1], A[i - 1] + f[i - 2]);
        }
        return f[A.length];
    }


    public static long houseRobber0(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        long old = 0;
        long now = A[0];
        long temp = 0;
        for (int i = 2; i <= A.length; i++) {
            temp = Math.max(now, A[i - 1] + old);
            old = now;
            now = temp;
        }
        return now;
    }
}
