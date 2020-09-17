package stack;

import java.util.Stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-25 19:32
 */
public class LeetCode224BaseCaculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                int temp = ch[i] - '0';
                while (i + 1 < ch.length && Character.isDigit(ch[i + 1])) {
                    i++;
                    temp *= 10;
                    temp += ch[i] - '0';
                }
                res = (sign == 1) ? (res + temp) : (res - temp);
            } else if (ch[i] == '+') {
                sign = 1;
            } else if (ch[i] == '-') {
                sign = -1;
            } else if (ch[i] == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch[i] == ')') {
                switch(stack.pop()) {
                    case 1:
                        res += stack.pop();
                        break;
                    case -1:
                        res = stack.pop() - res;
                        break;
                }
            }

        }
        return res;

    }
}
