package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-11 20:30
 */
public class Tree04Delete {
    public static boolean deleteNode(Tree01Node root, int id) {
        if (root == null)
            return false;
        if (root.getLeft() != null && root.getLeft().getValue() == id) {
            root.setLeft(null);
            return true;
        }
        if (root.getRight() != null && root.getRight().getValue() == id) {
            root.setRight(null);
            return true;
        }
        boolean b = deleteNode(root.getLeft(), id);
        if (b)
            return true;
        return deleteNode(root.getRight(), id);

    }
}

