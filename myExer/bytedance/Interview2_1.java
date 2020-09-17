package bytedance;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 模拟resource manager, 不断分配资源，
 * 查询最近给定长度的时间区间内最大的资源分配量。输入是指令的数组，
 * alloc n, t, 表示在t时间分配n个资源，如果为负数则为释放。
 * query t, 表示查询 [t-1000, t]时间段内最大的资源分配量。
 * @Author: MegaFrenzy
 * @CreateTime: 2020-09-07 下午60min
 *
 *  1.自我介绍
 *  2.问答部分
 *      C语言函数是怎么执行的，堆栈这里怎么处理的，能和汇编结合最好
 *      C语言调用函数后的返回值如何拿到
 *
 *      java垃圾回收介绍(说了垃圾如何判断，回收算法，垃圾回收器及其区别)
 *      java中使用instanceof同一个类为什么是false
 *      (提示类的加载后回答因为不属于同一个类加载器，只有同一个加载器同一个类才为True)
 *      乐观锁和悲观锁
 *
 *      操作系统内存管理的方式
 *      进程和线程的区别(说了一会感觉想让我停，我就没说了)
 *  3.算法部分
 *      模拟resource manager, 不断分配资源，
 *      查询最近给定长度的时间区间内最大的资源分配量。输入是指令的数组，
 *      alloc n, t, 表示在t时间分配n个资源，如果为负数则为释放。
 *      query t, 表示查询 [t-1000, t]时间段内最大的资源分配量。 *  4.反问部分
 *
 *
 */
public class Interview2_1 {
    private Queue<Alloc> queue = new LinkedList<>();

    private void slove(Object obj) {

        if (obj instanceof Alloc) {
            Alloc alloc = (Alloc) obj;
            if (queue.isEmpty()) {
                queue.offer(alloc);
                return;
            }
            int val = queue.peek().n;
            if (alloc.n < 0) {
                queue.offer(alloc);
            } else {
                while (!queue.isEmpty()) {
                    queue.poll();
                }
                queue.offer(alloc);
            }


        }
        if (obj instanceof Query) {
            Query q = (Query) obj;
            Alloc a = queue.poll();
            while (a.t < q.t - 1000) {
                queue.poll();
                a = queue.peek();
            }
            if (queue.isEmpty()) {
                System.out.println("time out");
                return;
            }
            int res = queue.peek().n;

        }
    }
    static class Alloc {
        int n;
        int t;
    }
    static class Query {
        int t;
    }

}
