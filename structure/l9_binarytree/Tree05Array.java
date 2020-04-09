package l9_binarytree;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-12 09:19
 */


class Demo{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Tree05Array t = new Tree05Array(arr);
        t.inOrder();
        System.out.println("-----");
        Tree01Node nodes = Tree05Array.arrToTree(arr);
        Tree02Traversal.preOrder(nodes);
        int[] arr2 = Tree05Array.treeToArr(nodes, 7);
        System.out.println(Arrays.toString(arr2));

    }
}
public class Tree05Array {


    int[] arr = null;

    public Tree05Array(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }
    private void preOrder(int index){
        if(arr==null||index>=arr.length)
            return;
        System.out.println(arr[index]);
        preOrder(index*2+1);
        preOrder(index*2+2);
    }

    public void inOrder(){
        inOrder(0);
    }
    private void inOrder(int index){
        if(arr==null||index>=arr.length)
            return;
        inOrder(index*2+1);
        System.out.println(arr[index]);
        inOrder(index*2+2);
    }
    public void postOrder(){
        postOrder(0);
    }
    private void postOrder(int index){
        if(arr==null||index>=arr.length)
            return;
        postOrder(index*2+1);
        postOrder(index*2+2);
        System.out.println(arr[index]);
    }

    //数组转树
    public static Tree01Node arrToTree(int[] arr){
        return arrToTree(arr,0);
    }

    private static Tree01Node arrToTree(int[] arr,int index){
        if(arr==null||index>=arr.length)
            return null;
        Tree01Node node = new Tree01Node(arr[index]);
        node.setLeft(arrToTree(arr,index*2+1));
        node.setRight(arrToTree(arr,index*2+2));
        return node;
    }
    //树转数组
    public static int[] treeToArr (Tree01Node root,int size){
        int[] arr= new int[size];
        treeToArr(root,arr,0);
        return arr;
    }
    private static void treeToArr (Tree01Node root,int[] arr,int index){
        if(root == null||index>=arr.length)
            return ;
        arr[index]=root.getValue();
        treeToArr(root.getLeft(),arr,index*2+1);
        treeToArr(root.getRight(),arr,index*2+2);

    }

}
