package l11_binarysorttree;

/**
 * @Description: 单个二叉树节点的类
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-14 16:50
 */
public class Node {
    public int value;
    public Node right;
    public Node left;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node) {
        if (node == null)
            return;
        if (node.value < this.value) {
            if (this.left == null)
                this.left = node;
            else
                this.left.add(node);
        } else {
            if (this.right == null)
                this.right = node;
            else
                this.right.add(node);
        }
    }

    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    //查找结点，返回结点对象
    public Node search(int value) {
        if (value == this.value)
            return this;
        if (this.left != null && value < this.value) {
            return this.left.search(value);
        }
        if (this.right != null && value >= this.value)
            return this.right.search(value);
        return null;
    }

    public Node searchParent(int value) {

        if ((this.left != null && value == this.left.value) ||
                (this.right != null && value == this.right.value))
            return this;
        if (this.left != null && value < this.value)
            return this.left.searchParent(value);
        if (this.right != null && value >= this.value)
            return this.right.searchParent(value);
        return null;
    }
}
