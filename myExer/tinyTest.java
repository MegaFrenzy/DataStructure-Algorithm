import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-07 11:06
 */
public class tinyTest {

    public static void main(String[] args) {

        //IntStream.range(1, 3).forEach(i -> System.out.println(5));

        tinyTest t = new tinyTest();
        int[] i = {-1, 5, -3, 5, 5, 5};
        //t.mergeSort(i, 0, i.length - 1, new int[i.length]);
        //System.out.println(Arrays.toString(i));
        String res = "123";
        String s = res.substring(0, res.length() - 1);
        System.out.println(s);

    }


    public void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) return;

        int mid = start + ((end - start) >> 1);
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);

        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int ls = start;
        int lEnd = start + ((end - start) >> 1);
        int rs = lEnd + 1;
        int idx = start;
        while (ls <= lEnd && rs <= end) {
            if (A[ls] <= A[rs]) {
                temp[idx++] = A[ls++];
            } else {
                temp[idx++] = A[rs++];
            }
        }
        while (ls <= lEnd) {
            temp[idx++] = A[ls++];
        }
        while (rs <= end) {
            temp[idx++] = A[rs++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end) return;

        int pivot = start + ((end - start) >> 1);
        int pivotVal = A[pivot];

        int left = start, right = end;
        while (left <= right) {
            while (left <= right && A[left] < pivotVal) left++;
            while (left <= right && A[right] > pivotVal) right--;

            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }

        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public void equationsPossible() {
        DisjointSet set = new DisjointSet(6);
        set.union(5, 2);
        set.union(5, 1);

        set.findRoot(5);

    }

    class DisjointSet {
        private int count;
        private int[] parent;

        public DisjointSet(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }

    public int translateNum(int num) {
        if (num <= 0) return 0;
        char[] ch = String.valueOf(num).toCharArray();
        int len = ch.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 1;

        int pre, post;
        for (int i = 2; i <= len; i++) {
            int muti = 0;
            pre = ch[i - 2] - '0';
            post = ch[i - 1] - '0';
            if (pre * 10 + post < 26) {
                muti++;
            }

            dp[i] = dp[i - 1] + muti;
        }
        return dp[len];
    }

}



