package bytedance;

import java.util.*;

/**
 * @Description: 请实现一个函数实现蛇形打印二叉树
 * 即第一行从左到右的顺序打印，第二行从右到左顺序打印，第三行从左到右…….
 *                10
 *              /   \
 *             6     13
 *           /  \   /  \
 *          3   8  11  16
 *  上图二叉树打印结果为
 *              10
 *              13 6
 *              3 8 11 16
 *  @Author: MegaFrenzy
 *  @CreateTime: 2020-08-11 下午45min
 *
 *
 *  1.自我介绍
 *  2.问答部分
 *      ArrayList的底层和扩容机制
 *      HashMap的扩容和树化条件
 *      HashMap在1.7 1.8的改动点，为什么要这么做
 *      不用Collections.SynchronizedMap和HashTable的原因
 *      ConcurrentHashMap在1.7 1.8的区别
 *      ThreadLocalMap遇到哈希冲突时的解决办法
 *  3.算法部分
 *      算法题：蛇形打印二叉树 lc103 广度优先遍历
 *      确定解题方式和参数列表
 *      写对应的测试类，跑测试数据打印
 *      时空复杂度
 *  4.问答部分2
 *      你所熟悉的框架中都用到了哪些设计模式
 *  5.反问部分
 *
 */


public class Interview1_1 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(16);

        List<List<Integer>> res = printTree(root);
        for (List<Integer> ele : res) {
            for (int a : ele) {
                System.out.print(a + " ");
            }
        }
    }

    private static List<List<Integer>> printTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        int reverse = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int nums = queue.size();
            for (int i = 0; i < nums; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            reverse = 1 - reverse;
            if (reverse == 1)  Collections.reverse(list);
            res.add(list);
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
