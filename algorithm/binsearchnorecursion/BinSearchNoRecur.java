package binsearchnorecursion;

/**
 * @Description: 非递归二分查找
 * @Author: MegaFrenzy
 * @CreateTime: 2020-04-01 11:40
 */
public class BinSearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 5, 5, 5, 9, 14, 16, 23, 31, 37, 53};
        System.out.println("索引值为:" +
                BinSearchNoRecur.firstPosition(arr, 5));
        System.out.println("索引值为:" +
                BinSearchNoRecur.lastPosition(arr, 5));
    }

    public static int firstPosition(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                end = mid;
            } else if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[start] == target) {
            return start;
        }
        if (arr[end] == target) {
            return end;
        }
        return -1;

    }
    public static int lastPosition(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                start = mid;
            } else if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[end] == target) {
            return end;
        }
        if (arr[start] == target) {
            return start;
        }
        return -1;

    }

    public static int binarySearch0(int[] arr, int target) {
        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        int midIdx;
        while (leftIdx <= rightIdx) {
            midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (arr[midIdx] == target) {
                return midIdx;
            } else if (arr[midIdx] > target) {
                rightIdx = midIdx - 1;
            } else {
                leftIdx = midIdx + 1;
            }
        }
        return -1;
    }
}
