package heap;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-07 15:39
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void heapSort(int[] A) {
        buildHeap(A, A.length - 1);
        for (int i = A.length - 1; i >= 0; i--) {
            swap(A, 0, i);
            buildHeap(A, i - 1);
        }
    }

    private void buildHeap(int[] A, int maxIdx) {
        int parent = (maxIdx - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(A, maxIdx, i);
        }
    }

    private void heapify(int[] A, int lastIdx, int idx) {   //在数组A中，从0-len-1把idx放在合适的位置上
        if (idx > lastIdx) return;
        int c1 = idx * 2 + 1;
        int c2 = idx * 2 + 2;
        int maxVIdx = idx;
        if (c1 <= lastIdx && A[c1] > A[maxVIdx]) {
            maxVIdx = c1;
        }
        if (c2 <= lastIdx && A[c2] > A[maxVIdx]) {
            maxVIdx = c2;
        }
        if (maxVIdx != idx) {
            swap(A, maxVIdx, idx);
            heapify(A, lastIdx, maxVIdx);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
