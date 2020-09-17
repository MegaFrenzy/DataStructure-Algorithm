package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 快速排序
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-26 下午45min
 *
 * 1.自我介绍和项目部分
 * 2.算法部分
 *      快速排序知道吗?先说下大概思路，多久可以写完(找轴分治，先试试吧)
 *      解释指定行数的代码，时空复杂度分析
 *      这几行会不会有什么问题，自己一直没发现也没报错最后被点出来....
 * 3.问答部分
 *      接口与抽象类的区别
 *      Java垃圾回收一条龙
 *
 *      TCP与UDP的区别
 *      TCP四次挥手
 *
 *      给一个200G以上的日志文件，每行都有时间戳和日志内容，问如何快速找到某个时间段的记录
 *      回答二分查找，问还有没有更优化的办法
 *      计算每小时日志数据量，推算出要查找日志的文件指针位置
 *      好像没回答到点子上，但是也没再问了
 *
 *      设计一个秒杀系统，对于百万QPS的请求如何保证不超买超卖
 *      你觉得自己优势在哪
 * 4.反问部分
 *
 *
 */
public class Interview1_3 {

    public static void main(String[] args) {
        int[] A = new int[]{5, 9, 4, 8, 7, 6, 7};

        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int mid = end + (start - end) / 2;
        int mid1 = start + (end - start) / 2;
        int midVal = A[mid];

        // 1    5    8    7    9    4    2

        int left = start, right = end;
        while (left <= right) {
            while (left <= right && A[left] < midVal) left++;
            while (left <= right && A[right] > midVal) right--;
            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);


    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



}
