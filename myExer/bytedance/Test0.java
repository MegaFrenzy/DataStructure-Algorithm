package bytedance;

import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-07-14 10:47
 */
public class Test0 {
    public static void main(String[] args) {
        int[] dp = new int[]{};
        System.out.println(dp == null);
        System.out.println(dp.length == 0);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        System.out.println(Arrays.toString(list.toArray()));
        //arraylist转int数组
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1.val - o2.val);
        minHeap.offer(new Pair(0, 0, matrix[0][0]));

        for (int i = 0; i < k - 1; i++) {
            Pair last = minHeap.poll();
            for (int p = 0; p < 2; p++) {
                int x = last.x + dx[p];
                int y = last.y + dy[p];
                if (x < m && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    minHeap.offer(new Pair(x, y, matrix[x][y]));
                }
            }
        }
        return minHeap.peek().val;
    }




}
class Pair {
    int x;
    int y;
    int val;
    Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
