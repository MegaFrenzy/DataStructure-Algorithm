package l12_avl;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-30 17:30
 */
public class Node {

    public int value;
    Node right;
    Node left;

    public Node(int value) {
        this.value = value;
    }

    public int getLeftHeight(){
        if(left==null)
            return 0;
        return left.getHeight();
    }
    public int getRightHeight(){
        if(right==null)
            return 0;
        return right.getHeight();
    }
    //返回以当前结点为根节点，树的高度
    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(),
                right == null ? 0 : right.getHeight()) + 1;
    }

    //左旋转
    private void leftRotate(){
        //以当前根节点的值创建结点
        Node newNode = new Node(value);
        newNode.left=left;
        newNode.right=right.left;
        value=right.value;
        left=newNode;
        right=right.right;

    }
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=right.left;
        value=left.value;
        left=left.left;
        right=newNode;
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
        if(this.getRightHeight()-this.getLeftHeight()>1){
           if(right!=null&&right.getLeftHeight()>right.getRightHeight())
               rightRotate();
            leftRotate();
            return;
        }
        if(this.getLeftHeight()-this.getRightHeight()>1){
            if(left!=null&&left.getLeftHeight()<left.getRightHeight())
                left.leftRotate();
            rightRotate();
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
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //根据数组构建二叉排序树
    public static Node buildTreeFromArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Node n = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            n.add(new Node(arr[i]));
        }
        return n;
    }
}
