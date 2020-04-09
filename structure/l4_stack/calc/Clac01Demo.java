package l4_stack.calc;

import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-03 10:56
 */
public class Clac01Demo {

    @Test
    public void test1(){
        Calc01Infix c0 = new Calc01Infix();
        String s0="39-10*1-10*2+2*5*6";
        System.out.println(c0.calc(s0));

        Calc01InfixEx c1 = new Calc01InfixEx();
        String s1="15-2*((20-3*3-2*2)-2)";
        System.out.println(c1.calc(s1));
    }

    @Test
    public void test2(){
        Calc02Suffix c2 = new Calc02Suffix();
        String s2 = "4 5 * 8 - 60 + 8 2 / +";
        System.out.println(Calc02Suffix.trans(s2));
        System.out.println(c2.calcFromList(s2));


    }
    @Test
    public void test3(){
        Infix2Suffix t1 = new Infix2Suffix();
        List<String> divide = t1.divide("15-2*((20-3*3-2*2)-2)");
        System.out.println(divide);
        List<String> trans = t1.trans(divide);
        System.out.println(trans);

    }
    @Test
    public void test4(){
        InfixExpCalc calc = new InfixExpCalc();
        String infixExpression = "1+((2.4+4.6)*4.8/2.2)*0.1";
        List<String> str = calc.getSuffixFromInfix(infixExpression);
        double res = calc.calcBySuffix(str);
        System.out.println(str);
        System.out.println(res);
    }
}
