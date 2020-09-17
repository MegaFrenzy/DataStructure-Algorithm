package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-21 23:31
 */
public class LeetCode239 {
    public static void main(String[] args) {
        LeetCode239 l = new LeetCode239();
        int[] r = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = l.maxSlidingWindow(r, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }
}
