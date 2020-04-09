package l4_stack.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-03 17:45
 */
public class Infix2Suffix {

    public List<String> divide(String exp) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            String s = exp.substring(i, i + 1);
            if (isNum(s)) {
                String num = s;
                while (i < exp.length() && isNum(exp.substring(i + 1, i + 2))) {
                    i++;
                    num += exp.substring(i, i + 1);
                }
                list.add(num);
            } else if (isOpt(s) || s.matches("[\\(\\)]")) {
                list.add(s);
            }
        }
        return list;

    }

    public List<String> trans(List<String> listIn) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        for (String s : listIn) {
            if (isNum(s)) {
                list.add(s);
            } else if (isOpt(s)) {

                while(!stack.empty()&&getLevel(s)<=getLevel(stack.peek())){
                    list.add(stack.pop());
                }
//                if(stack.empty()||getLevel(s)>getLevel(stack.peek())){
                    stack.push(s);
//                }
//                System.out.println(stack);
//                System.out.println(list);
            } else if ("(".equals(s)) {
                stack.push(s);
            } else if(")".equals(s)){
                while(!"(".equals(stack.peek())){
                    list.add(stack.pop());
                }
                stack.pop();
            }
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    public int getLevel(String s){
        int lv=0;
        switch(s){
            case "+":
            case "-":
                lv=1;
                break;
            case "*":
            case "/":
                lv=2;
                break;
            case "(":
                lv=-1;
                break;
            default:
                System.out.println("parameter error");
                break;
        }
        return lv;
    }
    public boolean isNum(String s) {
        return s.matches("\\d+");
    }

    public boolean isOpt(String s) {
        return s.matches("[\\+\\-\\*\\/]");
    }


}
