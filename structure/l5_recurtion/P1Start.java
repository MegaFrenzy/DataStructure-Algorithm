package l5_recurtion;

import org.junit.Test;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-04 10:03
 */
public class P1Start {
    @Test
    public void test1(){
        System.out.println(r1(3));
        r2(4);
    }

    public int r1(int i){
        if(i==0){
            return 1;
        }
        return i*r1(i-1);
    }
    public void r2(int i){
        System.out.println("i="+i);
        if(i>2){
            r2(i-1);
        }
    }
}
