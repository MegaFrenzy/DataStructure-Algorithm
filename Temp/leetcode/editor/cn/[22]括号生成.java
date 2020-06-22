//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        recursion(0, 0, n, "", list);
    }

    private void recursion(int left, int right, int n, String str, List list) {
        if (left == n && right == n) {
            list.add(str);
        }
        if (left <= n) {
            recursion(left + 1, right, n, str + "(",list);
        }
        if (right < left) {
            recursion(left, right + 1, n, str + "(",list);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
