package l4_stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 21:40
 */
public class LinkedStack<T> implements Stack<T> {

    private StackNode<T> top;

    public LinkedStack() {
        top = new StackNode<T>();
    }

    @Override
    public boolean isEmpty() {
        return top.next==null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T t) {

        StackNode<T> pushNode = new StackNode<>(t);
        pushNode.next=top.next;
        top.next=pushNode;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("stack underflow");
            return null;
        }
        StackNode<T> popNode=top.next;
        top=top.next;
        return popNode.data;

    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.println("stack underflow");
            return ;
        }
        StackNode<T> cursor=top;
        while(cursor.hasNext()){
            System.out.println(cursor=cursor.next);
        }
    }
}
