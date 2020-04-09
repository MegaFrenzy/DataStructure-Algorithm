package dynamicprogram1;

/**
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Input:  nums = [3,6,4]   Output: 6
 * Input:  nums = [2,3,2,3] Output: 6
 */
public class S10_HouseRobberII {
    public static void main(String[] args) {
        System.out.println(houseRobber0(new int[]{2, 3, 2, 3}));
        System.out.println(houseRobber0(new int[]{3, 6, 4}));
    }

    public static int houseRobber0(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int old = 0;
        int now1 = A[0];
        int now2 = A[1];
        int temp = 0;
        for (int i = 2; i < A.length; i++) {
            temp = Math.max(old + A[i - 1], now1);
            old = now1;
            now1 = temp;
        }
        old = 0;

        for (int i = 3; i < A.length + 1; i++) {
            temp = Math.max(old + A[i - 1], now2);
            old = now2;
            now2 = temp;
        }
        return Math.max(now1, now2);

    }
    //拷贝数组实现
    public static int houseRobber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] A = new int[n - 1];
        int res = Integer.MIN_VALUE;
        System.arraycopy(nums, 0, A, 0, n - 1);
//        for (int i = 0; i < n-1; i++) {
//            A[i] = nums[i];
//        }
        res = Math.max(res, calc(A));
        for (int i = 0; i < n - 1; i++) {
            A[i] = nums[i + 1];
        }
        res = Math.max(res, calc(A));
        return res;
    }

    public static int calc(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int old = 0;
        int now = A[0];
        int temp = 0;
        for (int i = 2; i <= A.length; i++) {
            temp = Math.max(now, A[i - 1] + old);
            old = now;
            now = temp;
        }
        return now;
    }
}
