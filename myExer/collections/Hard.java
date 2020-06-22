package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-15 21:14
 */
public class Hard {

    //leetcode560.
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int res = 0;
        int preSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // s[now] - s[past-1] == k
            // s[past] == s[now] - k
            preSum += nums[i];

            if (freq.containsKey(preSum - k)) {
                res += freq.get(preSum - k);
            }
            freq.put(preSum, freq.getOrDefault(preSum, 0) + 1);

        }
        return res;
    }
}
