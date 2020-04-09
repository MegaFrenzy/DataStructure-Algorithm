package dac;

/**
 * @Description: 使用分治算法divide-and-conquer
 * @Author: MegaFrenzy
 * @CreateTime: 2020-04-01 12:03
 */
public class Hanoitower {
    public static void main(String[] args) {
        //
        Hanoitower.hanoit(3,'A','B','C');
    }

    public static void hanoit(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("1号盘："+ a + "->" + c);
            return;
        }
        if (num > 1) {
            //将塔分为底下一个盘和上面剩余盘2个部分
            //将上面n-1个盘子从a借助c柱移动到b柱
            hanoit(num - 1, a, c, b);
            //将最底下的盘从a直接移动到c柱
            System.out.println(num + "号盘:" + a + "->" + c);
            //将上面n-1个盘子从b柱借助a移动到c柱
            hanoit(num - 1, b, a, c);
        }
    }
}
