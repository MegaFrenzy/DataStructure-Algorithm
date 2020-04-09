package dynamicprogram1;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1,'B' -> 2...'Z' -> 26
 * Given a non-empty string containing only digits,
 * determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class S6_DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(decodeWays(s));
    }

    public static int decodeWays(String s) {
        char[] arr = s.toCharArray();
        //f[i]表示前i位长度字符串的解码方式数
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = (arr[0] == '0') ? 0 : 1;
        int combine = 0;

        for (int i = 2; i <= s.length(); i++) {
            if (arr[i - 1] >= '1' && arr[i - 1] <= '9') {
                f[i] += f[i - 1];
            }
            combine = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
            if (combine >= 10 && combine <= 26) {
                f[i] += f[i - 2];
            }

        }
        return f[s.length()];
    }

//    public static int decodeWaysProblem(String s) {
//        int[] f = new int[s.length() + 1];
//        int part = 1;
//        int flg = 0;
//        f[0] = 0;
//        f[1] = (s.charAt(0) == '0') ? 0 : 1;
//        for (int i = 2; i <= s.length(); i++) {
//            part = 0;
//            flg = ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0'));
//            if (flg > 9 && flg < 27) {
//                part = 1;
//            }
//            f[i] = f[i - 1] + part;
//        }
//        return f[s.length()];
//    }
}
