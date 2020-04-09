package l4_stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 20:37
 */
public class ArrayStack<T> implements Stack<T> {

    private int stackSize;
    private T[] arr;
    private int top;
    public ArrayStack() {
        this(5);
    }
    public ArrayStack(int stackSize) {
        this.stackSize = stackSize;
        arr = (T[]) new Object[stackSize];
        top = -1;
    }

    public T peek(){
        return arr[top];
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public boolean isFull() {
        return top==stackSize-1;
    }

    @Override
    public void push(T t) {
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top]=t;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        return arr[top--];
    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }
}
