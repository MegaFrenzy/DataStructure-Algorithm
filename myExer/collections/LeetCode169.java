package collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: https://leetcode-cn.com/problems/majority-element/
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 14:23
 */
public class LeetCode169 {
    public static void main(String[] args) {
        int i = new LeetCode169().majorityElement(new int[]{3, 3, 4});

        int a =5;
    }
    public int majorityElement(int[] nums) {

        Map<Integer, Long> map0 =
                Arrays.stream(nums).boxed().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        System.out.println(map0);
        Map<Integer, Integer> map = countNum(nums);
        System.out.println(map);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        int resKey = 0, resValue = 0;
        for (Map.Entry<Integer, Integer> ele : set) {
            if (resValue < ele.getValue()) {
                resKey = ele.getKey();
                resValue = ele.getValue();
            }
        }

        return resKey;
    }
    private Map<Integer, Integer> countNum (int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
}

