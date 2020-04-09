package l11_binarysorttree;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-14 17:33
 */
public class Demo_l11 {
    public static void main(String[] args) {

    //          7
    //      3       10
    //    1   5   9    12
    //     2
        int[] arr={7,3,10,12,5,1,9,2};
        Node root = NodeTree.buildTreeFromArray(arr);
        NodeTree nt = new NodeTree(root);
        nt.inOrder();

        //测试删除叶子结点
        nt.deleteNode(2);
        nt.deleteNode(5);
        nt.deleteNode(9);
        nt.deleteNode(12);
        nt.deleteNode(7);
        nt.deleteNode(3);
        nt.deleteNode(10);
        nt.deleteNode(1);
        nt.deleteNode(10);
        System.out.println("删除结点后-------");
        nt.inOrder();
    }
}
