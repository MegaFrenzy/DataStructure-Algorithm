package recursion;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-15 19:02
 */
public class LeetCode51Queen {


    public static void main(String[] args) {
        List<List<String>> lists = new LeetCode51Queen().solveNQueens(4);
        for (List<String> ele : lists) {
            ele.forEach(System.out::println);
            System.out.println("========");
        }


    }


    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n < 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(board, 0);
        return res;
    }

    //将符合要求的矩阵存入list中
    private List<String> newRes(char[][] A) {
        List<String> ele = new ArrayList<>();
        for (char[] line : A) {
            //这里需要返回字符串"ABC"型，使用new String(line) 或 String.valueOf(line)
            //而不是"[A,B,C]"型，故不能使用Arrays.toString(line),
            ele.add(new String(line));
        }
        return ele;
    }

    private void backtrack(char[][] A, int n) {
        if (A.length == n) {
            res.add(newRes(A));
            return;
        }
        int xBound = A[n].length;
        for (int i = 0; i < xBound; i++) {
            if (!isValid(A, n, i)) {
                continue;
            }
            A[n][i] = 'Q';
            backtrack(A, n + 1);
            A[n][i] = '.';
        }
    }

    private boolean isValid(char[][] A, int row, int col) {
        int len = A.length;
        //同一列
        for (int i = 0; i < len; i++) {
            if (A[i][col] == 'Q') return false;
        }
        int c = col - 1, r = row - 1;
        //左上方
        while (c >= 0 && r >= 0) {
            if (A[r--][c--] == 'Q') return false;
        }
        //右上方
        c = col + 1;
        r = row - 1;
        while (c < len && r >= 0) {
            if (A[r--][c++] == 'Q') return false;
        }
        return true;
    }


//        public static class Solution2 {
//
//            /**
//             * 优化isValid的查询，通过3个set来分别记录列、主对角线、副对角线上Q的情况，减少迭代的查询
//             * Key值：colIndex, [r-c], [r + c] 作为set的key
//             */
//            private List<List<String>> res = new LinkedList<>();
//            private Set<Integer> colSet = new HashSet<>();
//            private Set<Integer> masterSet = new HashSet<>();
//            private Set<Integer> slaveSet = new HashSet<>();
//
//            public List<List<String>> solveNQueens(int n) {
//                char[][] board = new char[n][n];
//                for (char[] chars : board) Arrays.fill(chars, '.');
//                backtrack(board, 0);
//                return res;
//            }
//
//            /**
//             * path: board in [0, row -1]
//             * choices for a row : every cols
//             * time to end: row == board.length
//             *
//             * @param board
//             * @param row
//             */
//            private void backtrack(char[][] board, int row) {
//                if (row == board.length) {
//                    res.add(charToString(board));
//                    return;
//                }
//                for (int col = 0; col < board[row].length; col++) {
//                    if (!isValide(board, row, col)) continue;
//                    updateRecords(board, row, col);
//                    backtrack(board, row + 1);
//                    updateRecords(board, row, col);
//                }
//            }
//
//            private void updateRecords(char[][] board, int row, int col) {
//                if (colSet.contains(col)) {
//                    board[row][col] = '.';
//                    colSet.remove(col);
//                    masterSet.remove(row - col);
//                    slaveSet.remove(row + col);
//                } else {
//                    board[row][col] = 'Q';
//                    colSet.add(col);
//                    masterSet.add(row - col);
//                    slaveSet.add(row + col);
//                }
//            }
//
//            private boolean isValide(char[][] board, int row, int col) {
//                return !colSet.contains(col)
//                        && !masterSet.contains(row - col)
//                        && !slaveSet.contains(row + col);
//            }
//
//            @Test
//            public void test() {
//                List<List<String>> res = solveNQueens(4);
//                for (List<String> list : res) {
//                    for (String str : list) P.o(str);
//                    P.o("\n");
//                }
//
//            }
//        }


}
