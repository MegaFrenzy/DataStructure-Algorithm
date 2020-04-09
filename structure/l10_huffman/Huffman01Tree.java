package l10_huffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-13 23:23
 */
public class Huffman01Tree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preTraversal(root);
    }
    public static Node createHuffmanTree(int[] arr){
        if (arr == null || arr.length == 0)
            return null;
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while(nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node temp = new Node(leftNode.value + rightNode.value);
            temp.left=leftNode;
            temp.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(temp);
        }
        return nodes.get(0);
    }
    static class Node implements Comparable<Node>{

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }
    public static void preTraversal(Node node){
        if(node==null)
            return;
        System.out.println(node);
        preTraversal(node.left);
        preTraversal(node.right);
    }
}
