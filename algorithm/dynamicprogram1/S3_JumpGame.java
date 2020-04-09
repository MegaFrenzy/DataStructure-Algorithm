package dynamicprogram1;

/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 */
public class S3_JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,0,4};
        System.out.println(jumpGame(arr));
    }

    /**
     * @param arr : A list of integers
     * @return
     */
    public static boolean jumpGame(int[] arr) {
        boolean[] f = new boolean[arr.length];
        f[0] = arr[0] != 0;
        for (int i = 1; i < arr.length; i++) {
            f[i] = false;
            for (int j = 1; j <= i; j++) {
                f[i] = f[i] || (arr[i - j] >= j);
            }
        }
        return f[arr.length - 1];
    }
}
