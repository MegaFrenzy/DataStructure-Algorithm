package bytedance;

import java.util.Scanner;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-07-11 10:12
 */

/**
 * 我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，
 * 因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：
 *
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 * 我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。
 * 用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
 * ……
 * 万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，
 * 人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……
 *
 * 请听题：请实现大锤的自动校对程序
 * 输入
 * 2
 * helloo
 * wooooooow
 * 输出
 * hello
 * woow
 */
public class repairStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < amount; i++) {
            String s = sc.nextLine();
            System.out.println(repairStr(s));
        }
        sc.close();
    }

    public static String repairStr(String s) {
        if (s == null) return "";

        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < 2) {
                s1.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                continue;
            }
            s1.append(s.charAt(i));
        }

        String s2 = "";
        int lastSign = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (i < 3) {
                s2 += s1.charAt(i);
                continue;
            }
            if (s1.charAt(i) == s1.charAt(i - 1) &&
                    s1.charAt(i - 2) == s1.charAt(i - 3)) {
                if (lastSign == (i - 2)) {
                    s2 += s1.charAt(i);
                } else {
                    lastSign = i;
                }
                continue;
            }
            s2 += s1.charAt(i);
        }
        return s2;
    }

}

