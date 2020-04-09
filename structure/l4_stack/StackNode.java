package l4_stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 21:41
 */
public class StackNode<T>  {
    public T data;
    public StackNode<T> next;

    public StackNode(T value) {
        this.data = value;
    }

    public StackNode() {
    }


    public boolean hasNext(){
        return next!=null;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                '}';
    }
}
