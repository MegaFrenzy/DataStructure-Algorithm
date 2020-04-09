package l5_recurtion;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-04 11:00
 */
public class P2Maze {


    public int[][] maze;
    public int targetX;
    public int targetY;

    {
        maze = new int[10][10];

        for (int i = 0; i < maze.length; i++) {
            maze[0][i] = 1;
            maze[maze.length - 1][i] = 1;
            maze[i][0] = 1;
            maze[i][maze.length - 1] = 1;
        }
        maze[3][2] = 1;
        maze[3][3] = 1;
        maze[4][3] = 1;
        maze[5][1] = 1;
        maze[5][2] = 1;
        maze[5][3] = 1;


        targetX = maze.length - 2;
        targetY = maze[0].length - 2;
    }

    public P2Maze() {
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.printf("%4d", maze[i][j]);
            }
            System.out.println();
//            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println("----------------------");
    }

    public boolean bFindWay(int[][] map, int i, int j) {

        if (map[targetX][targetY] == 2) {
            return true;
        }

        if (map[i][j] == 0) {
            map[i][j] = 2;
            printMaze();
            if (bFindWay(map, i + 1, j)) {
                return true;
            } else if (bFindWay(map, i, j + 1)) {
                return true;
            } else if (bFindWay(map, i - 1, j)) {
                return true;
            } else if (bFindWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }

        }else{
            return  false;
        }

    }
}
