package l7_search;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 10:57
 */
public class S02InsertValue {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i * i / 2;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(insertVal(arr, 0, arr.length - 1, 1800));
    }

    public static int insertVal(int[] arr, int lo, int hi, int findVal) {
        System.out.println(lo + " " + hi + " " + findVal);
        if (lo > hi || findVal < arr[lo] || findVal > arr[hi]) {
            return -1;
        }
        int mid = lo + (hi - lo) * (findVal - arr[lo]) / (arr[hi] - arr[lo]);
        if (findVal < arr[mid]) {
            return insertVal(arr, lo, mid - 1, findVal);
        }
        if (findVal > arr[mid]) {
            return insertVal(arr, mid + 1, hi, findVal);
        }
            return mid;

    }
}
