package recursion;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-12 15:04
 */
public class DFS {



//    LeetCode102. 二叉树的层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> list = new LinkedList<>();
        if (root == null) return  new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> ele = new ArrayList<>();
            int row = queue.size();
            for (int i = 0; i < row; i++) {
                TreeNode node = queue.poll();
                ele.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.offerFirst(ele);
        }
        return new ArrayList<List<Integer>>(list);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>(set);
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> ele = new ArrayList<>();
        permuteDFS(nums,visited,0,ele,set);
        return new ArrayList<>(set);

    }
    private void permuteDFS(int[] nums, boolean[] visited, int depth, List<Integer> ele, Set<List<Integer>> set) {
        if (depth == nums.length) {
            set.add(new ArrayList<>(ele));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] =true;
                ele.add(nums[i]);
                permuteDFS(nums,visited,depth + 1, ele, set);
                visited[i] = false;
                ele.remove(ele.size() - 1);
            }
        }
    }

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
