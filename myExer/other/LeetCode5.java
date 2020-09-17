package other;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-25 19:15
 */
public class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 l = new LeetCode5();
        String s = l.longestPalindrome("babad");
        System.out.println(s);
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] str = s.toCharArray();
        String res = null;
        int maxLen = 0;
        for (int i = 0; i < str.length; i++) {
            String odd = getPal(str, i, i);
            String even = getPal(str, i, i + 1);
            String pld = odd.length() > even.length() ? odd : even;
            if (pld.length() > maxLen) {
                res = pld;
                maxLen = pld.length();
            }
        }
        return res;
    }
    private String getPal(char[] A, int i, int j) {
        if (i < 0 || j >= A.length) return "";
        while (i >= 0 && j < A.length) {
            if (A[i] == A[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        //System.out.println("i="+i+"#j="+j);
        //最后跳出2侧各多扩展了1个单位，本应是A,i, j-i+1(长度)
        return String.valueOf(A, i + 1, j - i - 1);
    }
}
