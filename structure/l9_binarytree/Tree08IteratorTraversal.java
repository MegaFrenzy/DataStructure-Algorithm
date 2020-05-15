package l9_binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-09 21:01
 */
public class Tree08IteratorTraversal {
    public static void main(String[] args) {
        Tree01Node root = new Tree01Node(4);
        root.left = new Tree01Node(1);
        root.right = new Tree01Node(7);
        root.right.left = new Tree01Node(5);
        System.out.println(inOrderTraversal(root).toString());
        System.out.println(preOrderTraversal(root).toString());
        System.out.println(postOrderTraversal(root).toString());

    }
    public static List<Tree01Node> preOrderTraversal0(Tree01Node root) {
        if(null == root) return new ArrayList<>();

        Stack<Tree01Node> stack = new Stack<>();
        List<Tree01Node> res = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Tree01Node node = stack.pop();
            res.add(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
    public static List<Integer> inOrderTraversal(Tree01Node root) {
        if(null == root) return new ArrayList<>();

        Stack<Object> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);


        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof Tree01Node) {
                Tree01Node node = (Tree01Node) obj;
                if (node.right != null) stack.push(node.right);
                stack.push(node.value);
                if (node.left != null) stack.push(node.left);
            } else {
                list.add((Integer)obj);
            }
        }
        return list;
    }
    public static List<Integer> preOrderTraversal(Tree01Node root) {
        if (null == root) return new ArrayList<>();

        Stack<Object> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof Tree01Node) {
                Tree01Node node = (Tree01Node) obj;
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node.value);
            } else {
                list.add((Integer)obj);
            }
        }
        return list;
    }
    public static List<Integer> postOrderTraversal(Tree01Node root) {
        if (root == null) return new ArrayList<>();

        Stack<Object> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof Tree01Node) {
                Tree01Node node = (Tree01Node) obj;
                stack.push(node.value);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                list.add((Integer) obj);
            }
        }
        return list;
    }
}
