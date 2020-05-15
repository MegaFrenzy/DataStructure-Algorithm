package collections;

import java.util.*;

/**
 * @Description: https://leetcode-cn.com/problems/group-anagrams/
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 18:59
 */
public class LeetCode49GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str0 = strs[i].toCharArray();
            int[] group = new int[26];
            for (char c : str0) {
                group[c - 'a']++;
            }
            /**
             * valueOf会调用参数内的toString方法，而数组的toString为内存地址
             * 所得的str为内存地址，如I@77f03bb1，在 map 添加时 key 不存在
             * hash碰撞的几率可以忽略，因此每个字符串都独立开辟了一个ArrayList
             * 使得结果为[[tea], [ate], [nat], [tan], [bat], [eat]]
             * 而非预期的[["bat"],["nat","tan"],["ate","eat","tea"]]
             */
//            String str = String.valueOf(group);
//            System.out.println(str);
//            if (!map.containsKey(str)) {
//                map.put(str, new ArrayList<>());
//            }
//            map.get(str).add(strs[i]);

            String strX = Arrays.toString(group);
            System.out.println(strX);
            System.out.println("=====");
            if (!map.containsKey(strX)) {
                map.put(strX, new ArrayList<>());
            }
            map.get(strX).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}
