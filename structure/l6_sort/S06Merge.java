package l6_sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-06 19:47
 */

public class S06Merge {

    public static void main(String[] args) {
        int[] arr = {1,4,7,8,3,6,9};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;//防止2个int相加超范围
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }

    private static void merge(int[] arr, int leftPoint, int rightPoint, int endBound) {
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
        System.out.printf("lo=%d,hi=%d\n",leftPoint,endBound);
        do {
            tp--;
            arr[leftPoint + tp] = temp[tp];
        } while (tp > 0);

    }
}
