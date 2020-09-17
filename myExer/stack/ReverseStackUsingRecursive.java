package stack;

import java.util.Stack;

/**
 * @Description: 仅用递归函数和栈操作逆序一个栈
 * @Author: MegaFrenzy
 * @CreateTime: 2020-09-08 13:07
 */
public class ReverseStackUsingRecursive {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastEle(stack);
        reverse(stack);
        stack.push(last);
    }
    public static int getAndRemoveLastEle(Stack<Integer> stack) {
        int cur = stack.pop();
        if(stack.isEmpty()) {
            return cur;
        }
        int last = getAndRemoveLastEle(stack);
        stack.push(cur);
        return last;
    }
}
