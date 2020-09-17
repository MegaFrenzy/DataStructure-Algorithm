package linkedlist;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-08-20 10:43
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;
        int val = 0;

        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            if (val >= 10) {
                carry = 1;
                val %= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            cursor.next = node;
            cursor = cursor.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        System.out.println(l1 == null);
        System.out.println(l2 == null);
        System.out.println(l1.val);

        if (l1 == null) cursor.next = l2;
        if (l2 == null) cursor.next = l1;
        if (carry == 1) cursor.next = new ListNode(1);
        return dummy.next;

    }
}
