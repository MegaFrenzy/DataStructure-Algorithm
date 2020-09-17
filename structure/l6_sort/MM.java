package l6_sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-09-14 14:31
 */
public class MM {
    public static void main(String[] args) {
        MM m = new MM();
        int[] A = new int[]{5, 8, 7, 9, 6, 4};
        m.mergeSort(A, 0, 5, new int[6]);
        System.out.println(A);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);

        merge(A, start, end, temp);

    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int left = start, leftEnd = start + (end - start) / 2;
        int right = leftEnd + 1;
        int idx = start;
        while (left <= leftEnd && right <= end) {
            if (A[left] <= A[right]) {
                temp[idx++] = A[left++];
            } else {
                temp[idx++] = A[right++];
            }
        }
        while (left <= leftEnd) {
            temp[idx++] = A[left++];
        }
        while (right <= end) {
            temp[idx++] = A[right++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}
