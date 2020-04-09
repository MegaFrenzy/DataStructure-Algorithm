package l7_search;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 11:40
 */
public class S03Fibonacci {
    public static void main(String[] args) {
        int[] arr = {1,5,8,9,10,15};
        int i = fibonacciSearch(arr, 15);
        System.out.println(i);
    }


    public static int[] getFibonacciArray() {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int fibonacciSearch(int[] arr, int findVal) {
        int[] f = getFibonacciArray();
        int k = 0;
        while (f[k] - 1 < arr.length) {
            k++;
        }
        int arrMax = arr[arr.length - 1];
        int[] fibArr = Arrays.copyOf(arr, f[k] - 1);

        for (int i = arr.length; i < fibArr.length; i++) {
            fibArr[i] = arrMax;
        }
        int lo = 0, hi = arr.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + f[k-1] - 1;
            if (findVal < fibArr[mid]) {
                hi = mid - 1;
                k--;
            } else if (findVal > fibArr[mid]) {
                lo = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, hi);
            }

        }
        return -1;
    }
}
