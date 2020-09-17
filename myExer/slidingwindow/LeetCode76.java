package slidingwindow;

/**
 * @Description: 滑动窗口中最大的值
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-21 22:06
 */
public class LeetCode76 {
    public static void main(String[] args) {
        LeetCode76 l = new LeetCode76();
        String s = l.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
        int t = 4;
    }

    public String minWindow(String s, String t) {

        int[] tplt = new int[256];  //template
        for (int i = 0; i < t.length(); i++) {
            tplt[t.charAt(i)]++;
        }
        int count = t.length();
        int startIdx = -1, len = Integer.MAX_VALUE;
        int[] map = new int[256];
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            while (j < s.length() && count > 0) {
                char c = s.charAt(j);
                map[c]++;
                if (map[c] <= tplt[c]) count--;
                j++;
            }
            if (len > j - i && count == 0) {
                len = j - i;
                startIdx = i;
            }
            char ci = s.charAt(i);
            map[ci]--;
            if (map[ci] < tplt[ci]) count++;

        }
        return s.substring(startIdx, startIdx + len);
    }
}
