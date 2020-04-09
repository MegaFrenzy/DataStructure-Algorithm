package l11_binarysorttree;

/**
 * @Description: 由结点构成的树的类，包含一个根结点
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-14 17:19
 */
public class NodeTree {
    private Node root;

    public NodeTree() {

    }

    public NodeTree(Node root) {
        this.root = root;
    }

    public void add(Node n) {
        if (root == null) {
            root = n;
        } else {
            root.add(n);
        }
    }

    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("empty tree ");
        }
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

    public Node search(int value) {
        if (root == null)
            return null;
        return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null)
            return null;
        return root.searchParent(value);
    }

    //删除二叉树结点
    public void deleteNode(int value) {
        if (root == null)
            return;
        //找到要删除的结点和父结点
        Node targetNode = search(value);
        if (targetNode == null)
            return;
        //如果只有根结点，则置空树
        if (root.left == null & root.right == null) {
            root = null;
            return;
        }
        Node parentNode = searchParent(value);
        //若为叶子结点，将父结点对应位置置空
        if (targetNode.left == null && targetNode.right == null) {
            if (parentNode.left != null && parentNode.left.value == value)
                parentNode.left = null;
            if (parentNode.right != null && parentNode.right.value == value)
                parentNode.right = null;

            //有两个子树的结点
        } else if (targetNode.left != null && targetNode.right != null) {
            targetNode.value = findDeleteMin(targetNode.right);

            //只有一个子树的结点
        } else {
            if (parentNode == null) {
                if (targetNode.left != null)
                    root = targetNode.left;
                if (targetNode.right != null)
                    root = targetNode.right;
                return;
            }
            if (parentNode.left != null && parentNode.left.value == value) {
                if (targetNode.left != null)
                    parentNode.left = targetNode.left;
                if (targetNode.right != null)
                    parentNode.left = targetNode.right;
            }
            if (parentNode.right != null && parentNode.right.value == value) {
                if (targetNode.left != null)
                    parentNode.right = targetNode.left;
                if (targetNode.right != null)
                    parentNode.right = targetNode.right;
            }

        }


    }

    public int findDeleteMin(Node n) {
        while (n.left != null) {
            n = n.left;
        }
        int temp = n.value;
        deleteNode(temp);
        return temp;
    }

}
