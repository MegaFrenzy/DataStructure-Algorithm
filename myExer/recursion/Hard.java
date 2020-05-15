package recursion;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-11 18:05
 */
public class Hard {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        TreeNode ans = new Hard().lowestCommonAncestor3(root, root.right, root.right.right);

        int t = 6;
    }

    //LeetCode236.

    //LintCode578
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode res = divConq(root, A, B);
        // 程序执行完之后查看是否两个都找到
        return foundA && foundB ? res : null;
    }

    private boolean foundA = false, foundB = false;

    private TreeNode divConq(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return root;
        TreeNode left = divConq(root.left, A, B);
        TreeNode right = divConq(root.right, A, B);
        // 如果 root 是要找的，更新全局变量
        if (root == A || root == B) {
            foundA = (root == A) || foundA;
            foundB = (root == B) || foundB;
            return root;
        }
        // 和 LCA 原题的思路一样
        if (left != null && right != null)
            return root;
        else if (left != null)    // 注意这种情况返回的时候是不保证两个都有找到的。可以是只找到一个或者两个都找到
            return left;        // 所以在最后上面要查看是不是两个都找到了
        else if (right != null)
            return right;
        return null;

    }
   //LeetCode114. 二叉树展开为链表
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftLast = flattenHelper(root.left);
        TreeNode rightLast = flattenHelper(root.right);
        TreeNode resLastNode = null;
        if (leftLast == null) {
            if (rightLast == null) {
                resLastNode = root;
            } else {
                resLastNode = rightLast;
            }
        } else {
            //connect to right
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            if (rightLast == null) {
                resLastNode = leftLast;
            } else {
                resLastNode = rightLast;
            }
        }
        return resLastNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
