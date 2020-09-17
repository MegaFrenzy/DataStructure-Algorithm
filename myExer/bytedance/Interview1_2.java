package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: 最长递增子序列
 *  给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 *  输入[2,1,5,3,6,4,8,9,7]    输出[1,3,4,8,9]
 *  输入[1,2,8,6,4]            输出[1,2,4]
 *  说明：其最长递增子序列有3个(1,2,8),(1,2,6),(1,2,4)其中第三个字典序最小，故答案为(1,2,4)
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-18 20:34
 *
 *
 * 1.项目介绍
 * 2.问答部分
 *      面向对象三大特性，重写和重载的区别，JVM和JRE区别
 *      操作系统线程通信方式
 *      java的锁，死锁的概念，死锁的消除，发现死锁如何解决
 *      synchronized和lock详细解析，ReentrantLock可重入原理，CAS和AQS，锁膨胀的升级过程，悲观锁和乐观锁
 *      mysql b树，b+树，聚簇索引，二级索引，哈希索引，自适应哈希，undo_log,bin_log,redo_log什么区别
 * 3.算法部分
 *      算法题：lc300并打印最小字典序 动态规划
 * 4.反问部分
 */

public class Interview1_2 {
    public static int[] LIS (int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        int len = arr.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        int maxLen = 0;     //保存最大长度
        HashMap<Integer, Integer> rec = new HashMap<>();
        for (int i = 1; i <= len; i++) {
            dp[i] = 1;
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] < arr[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] >= maxLen) {
                    maxLen = dp[i];
                    //记录每次增大序列时所用的最小值
                    if (!rec.containsKey(maxLen)) {
                        rec.put(maxLen, arr[i - 1]);
                    } else {
                        rec.put(maxLen,Math.min(arr[i - 1], rec.get(maxLen)));
                    }
                }
            }
        }
        int[] seq = new int[maxLen];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = rec.get(i + 1);
        }
        return seq;
    }
    public static void main(String[] args) {
        int[] res = LIS(new int[]{1,2,8,6,4});//2,1,5,3,6,4,8,9,7
        System.out.println(Arrays.toString(res));
        StringBuilder ss = new StringBuilder("01234567");
        System.out.println(ss);
        ss.deleteCharAt(2);
        System.out.println(new StringBuilder("559846").toString());

    }

}
