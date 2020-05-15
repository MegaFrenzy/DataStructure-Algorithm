package linkedlist;


/**
 * @Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-05 12:54
 */

public class LeetCode125ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (null == s || 0 == s.length()) {
            return true;
        }
        char[] ch = s.toLowerCase().toCharArray();
        int lo = 0, hi = ch.length - 1;
        while (lo < hi) {
            if (!isLetterOrDigit(ch[lo])) {
                lo++;
                continue;
            }
            if (!isLetterOrDigit(ch[hi])) {
                hi--;
                continue;
            }
            if (ch[lo] != ch[hi]) {
                return false;
            }
            hi--;
            lo++;
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}

