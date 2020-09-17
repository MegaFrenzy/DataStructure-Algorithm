package binsearchnorecursion;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-13 20:52
 */
public class LeetCode74SearchMartix {
    public static void main(String[] args) {
        int[][] q = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        LeetCode74SearchMartix s = new LeetCode74SearchMartix();
        boolean b = s.searchMatrix(q, 3);
        System.out.println(b);

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1, mid = 0;
        boolean res = false;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] < target) {
                start = mid;
            } else if (matrix[mid / n][mid % n] > target){
                end = mid;
            } else {
                res = true;
                break;
            }
        }
        if (matrix[start / n][start % n] == target) res = true;
        if (matrix[end / n][end % n] == target) res = true;

        return res;
    }
}
