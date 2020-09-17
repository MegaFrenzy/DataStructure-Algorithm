package recursion;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-07-03 15:09
 */
public class LeetCode108Array2BST {
    public static void main(String[] args) {
        LeetCode108Array2BST lt = new LeetCode108Array2BST();
        Basic01.TreeNode node = lt.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        int t = 1;
    }

    public Basic01.TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private Basic01.TreeNode helper(int[] A, int lo, int hi) {
        if (hi < lo) return null;
        int mid = lo + (hi - lo) / 2;
        Basic01.TreeNode node = new Basic01.TreeNode(A[mid]);
        node.left = helper(A, lo, mid - 1);
        node.right = helper(A, mid + 1, hi);
        return node;
    }
}
