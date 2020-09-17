package other;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-19 15:05
 */
public class IntAndChinese {
    //例：“五百三十万六千零三” -> 5306003。约束：输入金额在一亿以内。要求：做一定的容错处理，bug free。
    public static void main(String[] args) {
//        Random random = new Random();
//        int cont = 6;
//        int[] res = new int[cont + 1];
//        for (int i = 0; i < 10000; i++) {
//            res[random.nextInt(cont)]++;
//        }
//        System.out.println(Arrays.toString(res));
        //int res = transToInt("五百二十万六千");
        int res = transToInt("三百万零二百一十");
        System.out.println(res);
        String str = transToStr(84500906);
        System.out.println(str);
        double t = 0.05;

    }

    private static String transToStr(int num) {
        StringBuilder res = new StringBuilder();


        if (num >= 10000) {
            String s1 = transToStr(num / 10000);
            if (s1.charAt(s1.length() - 1) == '零') {
                s1 = s1.substring(0, s1.length() - 1);
            }
            String s2 = transToStr(num % 10000);
            s2 = (s2.length() > 1 && s2.charAt(1) != '千' && s2.charAt(0) != '零') ? '零' + s2 : s2;

            return s1 + '万' + s2;
        } else {
            if (num >= 1000) {
                res.append(num / 1000);
                res.append('千');
                num %= 1000;
            }
            if (num >= 100) {
                res.append(num / 100);
                res.append('百');
                num %= 100;
            } else {
                res.append('零');
            }
            if (num >= 10) {
                res.append(num / 10);
                res.append('十');
                num %= 10;
            } else {
                if (res.charAt(res.length() - 1) != '零') {
                    res.append('零');
                }
            }
            if (num != 0) {
                res.append(num);
            }
        }
        String str = res.toString();
        str = str.length() == 1 && str.charAt(0) == '零' ? "" : str;
        return str;
    }

    private static boolean onlyZero(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        for (char c : ch) {
            if (c != '0') return false;
        }
        return true;
    }

    public static Map<Character, Integer> numMap = new HashMap<Character, Integer>() {{
        put('一', 1);
        put('二', 2);
        put('三', 3);
        put('四', 4);
        put('五', 5);
        put('六', 6);
        put('七', 7);
        put('八', 8);
        put('九', 9);

    }};
    public static Map<Character, Integer> unitMap = new HashMap<Character, Integer>() {{
        put('千', 1000);
        put('百', 100);
        put('十', 10);
    }};

    private static int transToInt(String s) {

        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));
        if (!isValid(ch)) {
            System.out.println("error parameter");
            return -1;
        }
        int res = 0;
        int idx = 0;
        while (idx < ch.length) {
            if (ch[idx] == '万') {
                res *= 10000;
                idx++;
            } else if (numMap.containsKey(ch[idx])) {
                if (idx == ch.length - 1) {
                    res += numMap.get(ch[idx]);
                    idx++;
                } else {
                    res = res + numMap.get(ch[idx]) * unitMap.get(ch[idx + 1]);
                    idx += 2;
                }
            } else {
                idx++;
            }
        }
        return res;
    }

    private static boolean isValid(char[] ch) {
        boolean cNum = false;
        boolean cUnit = false;
        char unit = 0;
        for (int i = 0; i < ch.length; i++) {
            if (unitMap.containsKey(ch[i]) || ch[i] == '万') {
                if (cUnit) {
                    if (ch[i - 1] != '万' && ch[i] == '万') {
                        unit = ch[i];
                        continue;
                    }
                    return false;
                } else {
                    cUnit = true;
                    cNum = false;
                    if (ch[i] == unit) return false;
                    unit = ch[i];
                }

            } else if (numMap.containsKey(ch[i]) || ch[i] == '零') {
                if (cNum) {
                    if (ch[i - 1] == '零' && ch[i] != '零') continue;
                    return false;
                } else {
                    cUnit = false;
                    cNum = true;
                }
            }
        }
        return true;
    }

}


