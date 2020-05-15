package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-10 18:57
 */
public class Basic01 {
    public static void main(String[] args) {

    }
    //LeetCode22. 括号生成
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        makeParenthesis(0, 0, n, "", list);
        return list;
    }

    private void makeParenthesis(int left, int right, int n, String str, List<String> list) {
        if (left == n && right == n) {
            list.add(str);
        }
        if (left <= n) {
            makeParenthesis(left + 1, right, n, str + "(", list);
        }
        if (right < left) {
            makeParenthesis(left, right + 1, n, str + ")", list);
        }

    }

    //LeetCode98. 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return bstTraversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean bstTraversal(TreeNode node, long bottom, long top) {
        if (node == null) return true;
        if (node.val <= bottom || node.val >= top) return false;
        boolean b1 = bstTraversal(node.left, bottom, node.val);
        boolean b2 = bstTraversal(node.right, node.val, top);
        return b1 && b2;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    LeetCode50. Pow(x, n)
//    Accepted
//    public double myPow(double x, int n) {
//        double ans = powRecursion(x, Math.abs((long)n));
//        return n >= 0 ? ans : 1.0 / ans;
//    }
//    private double powRecursion(double x, long n){
//        if (0 == n) return 1.0 ;
//        double db = powRecursion(x, n / 2);
//        double ans;
//        if (n % 2 == 1) {
//            ans = x * db * db;
//        } else {
//            ans = db * db;
//        }
//        return ans;
//    }

    //Wrong Answer : 在powRecursion函数中要保证n大于0
    //否则要在递归函数中对2取余后取绝对值
    public double myPow(double x, int n) {
        double ans = powRecursion(x, Math.abs(n));
        return n >= 0 ? ans : 1 / ans;
    }

    private double powRecursion(double x, int n) {
        if (0 == n) return 1.0D;
        double db = powRecursion(x, n / 2);
        double ans;
        if (Math.abs(n % 2) == 1) { //修改后可Accepted
            ans = x * db * db;
        } else {
            ans = db * db;
        }
        return ans;
    }

    //LeetCode17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterTraversal("", digits.toCharArray(), 0, map, list);
        return list;
    }

    private void letterTraversal(String resStr, char[] dig, int idx,
                                 Map<Character, String> map, List<String> list) {
        if (idx == dig.length) {
            list.add(resStr);
            return;
        }
        char[] selectCh = map.get(dig[idx]).toCharArray();
        for (char ch : selectCh) {
            letterTraversal(resStr + ch, dig, idx + 1, map, list);
        }
    }
}
