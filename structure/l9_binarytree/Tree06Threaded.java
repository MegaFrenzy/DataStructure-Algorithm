package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-12 23:16
 */
public class Tree06Threaded {

    static class ThreadedNode {
        int value;
        ThreadedNode left;
        ThreadedNode right;
        boolean isLeftThread;
        boolean isRightThread;

        @Override
        public String toString() {
            return "ThreadedNode{" +
                    "value=" + value +
                    '}';
        }
    }
    //中序线索化二叉树
    public static void inOrderThreadedTree(ThreadedNode root) {
        Tree06Threaded.inOrderThreadedTree(root, null);
    }

    public static void inOrderThreadedTree(ThreadedNode root, ThreadedNode pre) {
        if (root == null)
            return;
        inOrderThreadedTree(root.left, pre);
        if (root.left == null) {
            root.left = pre;
            root.isLeftThread = true;
        }
        if (pre != null && pre.isRightThread) {
            pre.right = root;
            pre.isRightThread = true;
        }
        pre = root;
        inOrderThreadedTree(root.right, pre);
    }
    //中序遍历线索化二叉树
    public static void inOrderTraversal(ThreadedNode node) {
        if (node==null)
            return;
        while (node!=null){
            while (!node.isLeftThread){
                node=node.left;
            }
            System.out.println(node);
            while (node.isRightThread){
                System.out.println(node.right);
                node=node.right;
            }
            node=node.right;
        }
    }


}
