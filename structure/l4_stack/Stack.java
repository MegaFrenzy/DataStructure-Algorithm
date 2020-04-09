package l4_stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 20:33
 */
public interface Stack<T> {

    public boolean isEmpty();
    public boolean isFull();
    public void push(T t);
    public T pop();
    public void print();
}
