package l4_stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 21:08
 */
public class Demo04 {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(10);
        stack.push(28);
        stack.push(12);
        stack.push(84);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
    }
}
