package l7_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-08 09:58
 */
public class S01Binary {
    public static void main(String[] args) {
        int[] arr = {1,1, 8, 10, 89, 106, 4812};
        int i = binarySearch(arr, 0, arr.length, 1);
        List<Integer> list = binarySearchMuti(arr, 0, arr.length, 1);
        System.out.println(list);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        int midVal = arr[mid];
        if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearchMuti(int[] arr, int left, int right, int findVal) {
        if (left > right)
            return new ArrayList<>();
        int mid = left + (right - left) / 2;
        int midVal = arr[mid];
        if (findVal < midVal) {
            return binarySearchMuti(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            return binarySearchMuti(arr, mid + 1, right, findVal);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = mid - 1; i >= 0 && arr[i] == findVal; i--) {
            list.add(i);
        }
        list.add(mid);
        for (int i = mid + 1; i < arr.length && arr[i] == findVal; i++) {
            list.add(i);
        }
        return list;
    }
}
