package l4_stack.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-03 23:17
 */
public class InfixExpCalc {


    private static HashMap<String, Integer> optLevel = new HashMap<>();

    static {
        optLevel.put("+", 1);
        optLevel.put("-", 1);
        optLevel.put("*", 2);
        optLevel.put("/", 2);
        optLevel.put("(", 0);
    }

    public List<String> getSuffixFromInfix(String InfixExp) {
        ArrayList<String> list = new ArrayList<>();
        String strExp = InfixExp.replaceAll("[\\s]+", "");
        Stack<String> stack = new Stack<>();

        String s;
        for (int i = 0; i < strExp.length(); i++) {
            s = strExp.substring(i, i + 1);
            if (isNum(s)) {
                while (i < strExp.length() - 1 && isNum(strExp.substring(i + 1, i + 2))) {
                    i++;
                    s += strExp.substring(i, i + 1);
                }
                list.add(s);
            } else if (isOpt(s)) {
                while (!stack.empty() && optLevel.get(s) <= optLevel.get(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(s);
            } else if ("(".equals(s)) {
                stack.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.pop();
            }

        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public double calcBySuffix(List<String> listIn) {
        Stack<Double> s0 = new Stack<>();

        for (String s : listIn) {
            if (isNum(s)) {
                s0.push(Double.parseDouble(s));
            } else if (isOpt(s)) {
                Double dTop = s0.pop();
                Double dSubTop = s0.pop();
                s0.push(metaCalc(dSubTop, dTop, s));
            }
        }

        return s0.pop();
    }

    public boolean isNum(String s) {
        return s.matches("[\\.|\\d]+");
    }

    public boolean isOpt(String s) {
        return s.matches("[\\+|\\-|\\*||\\/]");
    }

    private double metaCalc(double subTop, double top, String Operator) {
        double res = 0;
        switch (Operator) {
            case "+":
                res = subTop + top;
                break;
            case "-":
                res = subTop - top;
                break;
            case "*":
                res = subTop * top;
                break;
            case "/":
                res = subTop / top;
                break;
        }
        return res;
    }
}
