package linkedlist;

/**
 * @Description: 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输入:
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * 输出: 1->1->2->3->4->4->5->6
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-02 15:57
 */
public class LeetCode23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy.next;


        return dummy.next;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }


    public String print() {
        String str = this.val + "";
        ListNode node = this;
        while (node.next != null) {
            str += "->" + node.next.val;
            node = node.next;
        }
        return str;
    }
}
