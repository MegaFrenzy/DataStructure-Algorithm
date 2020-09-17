package l6_sort;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-02 20:03
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int pivotVal = A[left + (right - left) / 2];
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

}
