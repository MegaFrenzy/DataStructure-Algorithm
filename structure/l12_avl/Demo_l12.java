package l12_avl;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-30 17:48
 */
public class Demo_l12 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr2 = {10, 12, 8, 9, 7, 6};
        Node root = Node.buildTreeFromArray(arr2);
        AvlTree avltree = new AvlTree(root);
        avltree.inOrder();

        System.out.println("树的高度 = " + avltree.getRoot().getHeight());
        System.out.println("树的左子树高度 = " + avltree.getRoot().getLeftHeight());
        System.out.println("树的高度 = " + avltree.getRoot().getRightHeight());
        System.out.println("当前的根结点 = " + avltree.getRoot());

    }
}

