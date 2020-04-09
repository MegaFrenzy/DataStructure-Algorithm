package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-11 09:41
 */
public class Tree02Traversal {

    public static void preOrder(Tree01Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public static void inOrder(Tree01Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node);
        inOrder(node.getRight());
    }

    public static void postOrder(Tree01Node node) {
        if (null == node) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node);
    }
}
