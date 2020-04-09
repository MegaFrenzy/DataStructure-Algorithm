package l5_recurtion;

import org.junit.Test;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-04 11:11
 */
public class P0Demo {
    @Test
    public void p2Test() {
        P2Maze p2 = new P2Maze();
        boolean b = p2.bFindWay(p2.maze, 1, 1);

    }

    @Test
    public void p3Test() {
        P3Queen p3 = new P3Queen(8);
        p3.calc();
    }
}
