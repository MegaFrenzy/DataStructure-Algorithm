package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-11 16:35
 */
public class Basic02 {
    public static void main(String[] args) {
        Basic01.TreeNode node = new Basic01.TreeNode(1);
        node.left=new Basic01.TreeNode(2);
        node.left.right = new Basic01.TreeNode(5);
        node.right = new Basic01.TreeNode(3);

        System.out.println(new Basic02().binaryTreePaths(node));
    }

    //LintCode408.二叉树的所有路径
    //1.Method Definition
    public List<String> binaryTreePaths(Basic01.TreeNode root) {
        List<String> list = new ArrayList<>();
        //3.exit
        if (root == null) return list;

        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        //2.split
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);

        for (String str : leftList) {
            list.add(root.val + "->" + str);
        }
        for (String str : rightList) {
            list.add(root.val + "->" + str);
        }
        return list;
    }

    //LintCode597.findSubtree2给一棵二叉树，找到有最大平均值的子树。返回子树的根结点
    private class ResType {
        private int sumVal;
        private int amount;

        public ResType(int sumVal, int amount) {
            this.sumVal = sumVal;
            this.amount = amount;
        }
    }

    private ResType maxParam = null;
    private TreeNode maxAvgNode = null;

    public TreeNode findSubtree2(TreeNode root) {
        calcAvgNode(root);
        return maxAvgNode;
    }

    private ResType calcAvgNode(TreeNode root) {
        if (root == null) return new ResType(0, 0);

        ResType resLeft = calcAvgNode(root.left);
        ResType resRight = calcAvgNode(root.right);
        int rootVal = resLeft.sumVal + resRight.sumVal + root.val;
        int rootCnt = resLeft.amount + resRight.amount + 1;
        ResType result = new ResType(rootVal, rootCnt);
        // rootVal/rootCnt  > maxVal/maxValAmount
        if (maxParam == null || rootVal * maxParam.amount > maxParam.sumVal * rootCnt) {
            maxParam = result;
            maxAvgNode = root;
        }
        return result;
    }

    //LintCode596.二叉树的所有路径
    private Basic01.TreeNode minNode = null;
    private int minVal = Integer.MAX_VALUE;
    public Basic01.TreeNode findSubtree(Basic01.TreeNode root) {
        divide(root);
        return minNode;
    }

    private int divide(Basic01.TreeNode root) {

        if (root == null) return 0;
        int leftVal = divide(root.left);
        int rightVal = divide(root.right);
        int rootVal = leftVal + rightVal + root.val;
        if (rootVal < minVal) {
            minVal = rootVal;
            minNode = root;
        }
        return rootVal;
    }

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }


}


