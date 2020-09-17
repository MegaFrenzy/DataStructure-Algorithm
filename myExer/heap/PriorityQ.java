package heap;


import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-24 11:19
 */
public class PriorityQ {
    //实现小顶堆，用来保存数据流种前k个最大的数
    public static void main(String[] args) {
        int[] input = new int[]{9, 8, 7, 5, 9, 4, 8, 6, 4, 10, 15};

        PriorityQ queue = new PriorityQ();
        int[] res = new int[4];
        for (int i = 0; i < res.length; i++) res[i] = input[i];
        queue.buildHeap(res, 3);

        for (int i = res.length; i < input.length; i++) {
            queue.adjust(res, input[i]);
        }

        System.out.println(Arrays.toString(res));
    }

    private void adjust(int[] A, int ins) {
        if (A[0] >= ins) return;
        A[0] = ins;
        heapify(A, A.length - 1, 0);
    }

    private void buildHeap(int[] A, int maxIdx) {
        int parent = (maxIdx - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(A, maxIdx, i);
        }
    }

    private void heapify(int[] A, int lastIdx, int idx) {
        if (idx > lastIdx) return;
        int c1 = idx * 2 + 1;
        int c2 = idx * 2 + 2;

        int minValIdx = idx;
        if (c1 <= lastIdx && A[c1] < A[minValIdx]) {
            minValIdx = c1;
        }
        if (c2 <= lastIdx && A[c2] < A[minValIdx]) {
            minValIdx = c2;
        }
        if (idx != minValIdx) {
            swap(A, idx, minValIdx);
            heapify(A, lastIdx, minValIdx);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
