package l4_stack.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-03 15:17
 */
public class Calc02Suffix {


    public static List<String> trans(String suffixExp) {
        return new ArrayList<>(Arrays.asList(suffixExp.split(" +")));
    }

    public static int calcFromList(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (isNum(s)) {
                stack.push(Integer.parseInt(s));
            } else if (isOpt(s)) {
                int iTop = stack.pop();
                int iSubTop = stack.pop();
                int res = metaCal(iSubTop, iTop, s.charAt(0));
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public int calcFromList(String suffixExp) {
        List<String> list = trans(suffixExp);
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (isNum(s)) {
                stack.push(Integer.parseInt(s));
            } else if (isOpt(s)) {
                int iTop = stack.pop();
                int iSubTop = stack.pop();
                int res = metaCal(iSubTop, iTop, s.charAt(0));
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static boolean isNum(String str) {
        return str.matches("\\d+");
    }

    public static boolean isOpt(String str) {
        return str.matches("[\\+\\-\\*\\/]");
    }

    public static int metaCal(int iSubTop, int iTop, char opt) {
        int res = 0;
        switch (opt) {
            case '+':
                res = iSubTop + iTop;
                break;
            case '-':
                res = iSubTop - iTop;
                break;
            case '*':
                res = iSubTop * iTop;
                break;
            case '/':
                res = iSubTop / iTop;
                break;
            default:
                System.out.println("incorrect parameter");
                break;
        }
        return res;
    }
}
