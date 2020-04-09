package l9_binarytree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-11 10:20
 */
public class Tree00Demo {
    public static void main(String[] args) {
        //          1
        //     2        3
        //  4    5    6
        //   7
        Tree01Node[] nodes = new Tree01Node[8];
        for (int i = 0; i < 8; i++) {
            nodes[i] = new Tree01Node(i);
        }
        nodes[1].setLeft(nodes[2]);
        nodes[1].setRight(nodes[3]);
        nodes[2].setLeft(nodes[4]);
        nodes[2].setRight(nodes[5]);
        nodes[3].setLeft(nodes[6]);
        nodes[4].setLeft(nodes[7]);

//        TraversalUtil.preOrder(nodes[1]);
//        System.out.println("-----");
//        TraversalUtil.inOrder(nodes[1]);
//        System.out.println("-----");
//        TraversalUtil.postOrder(nodes[1]);
//        System.out.println("-----");

//        TreeNode n = SearchUtil.inSearch(nodes[1], 2);
//        if (n != null)
//            System.out.println(n);
//        else
//            System.out.println("n is null");
        Tree02Traversal.preOrder(nodes[1]);
        System.out.println("-----");
        Tree04Delete.deleteNode(nodes[1],1);
        Tree02Traversal.preOrder(nodes[1]);
        System.out.println("-----");
    }
}
