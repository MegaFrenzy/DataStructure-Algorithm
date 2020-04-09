package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-11 09:37
 */
public class Tree01Node {
    private int value;
    private Tree01Node left;
    private Tree01Node right ;

    public Tree01Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree01Node getLeft() {
        return left;
    }

    public void setLeft(Tree01Node left) {
        this.left = left;
    }

    public Tree01Node getRight() {
        return right;
    }

    public void setRight(Tree01Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }




}
