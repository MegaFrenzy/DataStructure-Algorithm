package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description: PriorityQueue
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-02 20:55
 */
public class LeetCode347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int f = freq.getOrDefault(num, 0) + 1;
            freq.put(num, f);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> freq.get(o1) - freq.get(o2));
        Set<Integer> freqSet = freq.keySet();
        for (Integer ele : freqSet) {
            minHeap.offer(ele);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
