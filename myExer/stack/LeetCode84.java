package stack;

import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 19:06
 */
public class LeetCode84 {

    //84. 柱状图中最大的矩形  Stack单调栈
    public static int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        if (heights.length == 1) return heights[0];
        int[] A = new int[heights.length + 2];
        System.arraycopy(heights, 0, A, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int res = 0;
        for (int i = 1; i < A.length; i++) {
            while (A[i] < A[stack.peek()]) {
                int w = i - stack.peek() ;
                int h = A[stack.pop()] ;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;

    }

    /**
     * Two Pointer
     * leetcode15.给一个包含n个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k == 0 || nums[k - 1] != nums[k]) {
                int i = k + 1, j = nums.length - 1, sum = -nums[k];
                while (i < j) {
                    if (nums[i] + nums[j] == sum) {
                        list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i + 1] == nums[i]) i++;
                        while (i < j && nums[j - 1] == nums[j]) j--;
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] < sum) i++;
                    else j--;
                }
            }
        }
        return list;
    }

}
