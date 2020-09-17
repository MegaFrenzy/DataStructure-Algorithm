package l6_sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-06 19:47
 */

public class S06Merge {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 7, 8, 3, 6, 9};
//        int[] arr = {-1, 5, -3, 5, 5, 5};
        int[] arr = {-1, 5, -3, 9, 8, 6, 0, 2};

        int[] temp = new int[arr.length];
        mergeSort2(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //区间-分治
    public static void mergeSort2(int[] A, int startIdx, int endIdx, int[] temp) {
        if (startIdx >= endIdx) {
            return;
        }
        mergeSort2(A, startIdx, startIdx + (endIdx - startIdx) / 2, temp);
        mergeSort2(A, startIdx + (endIdx - startIdx) / 2 + 1, endIdx, temp);
        System.out.println(startIdx + "#" + endIdx);
        merge2(A, startIdx, endIdx, temp);
    }

    private static void merge2(int[] A, int start, int end, int[] temp) {
        int l1 = start, leftEnd = start + (end - start) / 2, r1 = leftEnd + 1;
        int idx = start;
        while (l1 <= leftEnd && r1 <= end) {
            if (A[l1] <= A[r1]) {
                temp[idx++] = A[l1++];
            } else {
                temp[idx++] = A[r1++];
            }
        }
        while (l1 <= leftEnd) {
            temp[idx++] = A[l1++];
        }

        while (r1 <= end) {
            temp[idx++] = A[r1++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        System.out.println(Arrays.toString(temp));
        //if (end + 1 - start >= 0) System.arraycopy(temp, start, A, start, end + 1 - start);
    }


    public static void mergeSort1(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;//防止2个int相加超范围
        mergeSort1(arr, left, mid);
        mergeSort1(arr, mid + 1, right);
        merge1(arr, left, mid + 1, right);
    }

    private static void merge1(int[] arr, int leftPoint, int rightPoint, int endBound) {
        int[] temp = new int[endBound - leftPoint + 1];
        int lp = leftPoint, rp = rightPoint, tp = 0;
        while (lp <= rightPoint - 1 && rp <= endBound) {
            temp[tp++] = (arr[lp] <= arr[rp]) ? arr[lp++] : arr[rp++];
        }
        while (lp <= rightPoint - 1) {
            temp[tp++] = arr[lp++];
        }
        while (rp <= endBound) {
            temp[tp++] = arr[rp++];
        }
        //System.out.printf("tp=%d,lp=%d,rp=%d\n",tp,lp,rp);
        System.out.printf("lo=%d,hi=%d\n", leftPoint, endBound);
        do {
            tp--;
            arr[leftPoint + tp] = temp[tp];
        } while (tp > 0);

    }
}
