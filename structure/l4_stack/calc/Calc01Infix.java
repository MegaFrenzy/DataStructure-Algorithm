package l4_stack.calc;

import l4_stack.ArrayStack;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-03 09:15
 */
public class Calc01Infix {


    public int calc(String exp) {
        ArrayStack<Integer> numStack = new ArrayStack<>();
        ArrayStack<Character> optStack = new ArrayStack<>();
        char ch;
        //遍历中缀表达式存入栈
        for (int i = 0; i < exp.length(); i++) {
            ch=exp.charAt(i);
            if(isNum(ch)){
                String strNum=""+ch;
                while(i+1<exp.length()&&isNum(ch=exp.charAt(i+1))){
                    strNum+=ch;
                    i++;
                }
                numStack.push(Integer.parseInt(strNum));
            }else if(isOpt(ch)){
                if(optStack.isEmpty()||getLevel(ch)>getLevel(optStack.peek())){
                    optStack.push(ch);
                    continue;
                }
                while(!optStack.isEmpty()&&getLevel(ch)<=getLevel(optStack.peek())){
                    Integer firstPop = numStack.pop();
                    Integer secondPop = numStack.pop();
                    Character operator = optStack.pop();
                    int metaNum = metaCal(secondPop, firstPop, operator);
                    numStack.push(metaNum);
                }
                optStack.push(ch);
            }
        }
        //根据栈计算结果
        while(!optStack.isEmpty()){
            Integer firstPop = numStack.pop();
            Integer secondPop = numStack.pop();
            Character operator = optStack.pop();
            int metaNum = metaCal(secondPop, firstPop, operator);
            numStack.push(metaNum);
        }
        return numStack.pop();
    }

    public boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public boolean isOpt(char ch) {
        return ch == '*' ||
                ch == '/' ||
                ch == '+' ||
                ch == '-';
    }
    public int getLevel(char opt){
        int res=0;
        switch (opt){
            case '+':
            case '-':
                res = 1;
                break;
            case '*':
            case '/':
                res = 2;
                break;
            default:
                res=-1;
                break;
        }
        return res;
    }
    public int metaCal(int iSubTop, int iTop, char opt) {
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
