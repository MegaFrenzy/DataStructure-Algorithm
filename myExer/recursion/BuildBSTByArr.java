package recursion;

/**
 * @Description: 已知二叉搜索树的后序遍历数组，根据arr重建整个数，返回头结点
 * @Author: MegaFrenzy
 * @CreateTime: 2020-07-31 15:45
 */
public class BuildBSTByArr {
    public static void main(String[] args) {
        BuildBSTByArr b = new BuildBSTByArr();
        TreeNode node = b.buildByArr(new int[]{3, 7, 6, 10, 12, 9});
        int a = 5;
    }

    public TreeNode buildByArr(int[] arr) {
        return solution(arr, 0, arr.length - 1);
    }

    public TreeNode solution(int[] A, int L, int R) {
        if (L > R) {
            return null;
        }

        TreeNode root = new TreeNode(A[R]);
        if (L == R) {
            return root;
        }
        int border = -1;
        int cursor = L;
        while (A[cursor] < A[R]) {
            border = cursor;
            cursor++;
        }
//        for (int i = L; i < R; i++) {
//            if (A[i] < A[R]) {
//                border = i;
//            }
//        }
        if (border == -1) {
            root.right = solution(A, L, R - 1);
        } else if (border == (R - 1)) {
            root.left = solution(A, L, R - 1);
        } else {
            root.left = solution(A, L, border);
            root.right = solution(A, border + 1, R - 1);
        }
        return root;

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
