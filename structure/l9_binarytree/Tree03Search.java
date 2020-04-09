package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-11 11:03
 */
public class Tree03Search {

    public static Tree01Node preSearch(Tree01Node root, int id) {
       if (root == null) {
            return null;
        }
        System.out.println("start pre-search...");
        if (root.getValue() == id) {
            return root;
        }
        Tree01Node node = preSearch(root.getLeft(), id);
        if (node != null)
            return node;
        return preSearch(root.getRight(), id);

    }

    public static Tree01Node inSearch(Tree01Node root, int id) {
        if (root == null)
            return null;
        Tree01Node node = inSearch(root.getLeft(), id);
        if (node != null) {
            return node;
        }
        System.out.println("start in-search...");
        if (root.getValue() == id)
            return root;
        return inSearch(root.getRight(), id);
    }

    public static Tree01Node postSearch(Tree01Node root, int id) {
        if (root == null)
            return null;
        Tree01Node node = postSearch(root.getLeft(), id);
        if (node != null)
            return node;
        node = postSearch(root.getRight(), id);
        if (node != null)
            return node;
        if(root.getValue()==id)
            return root;
        return null;
    }
}
