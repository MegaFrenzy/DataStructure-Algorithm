package l3_linkedlist.linkedList02SingleCircle;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-01 23:20
 */

public class ListNode {
    public ListNode next;
    public int value;

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }

    public ListNode() {

    }

    public ListNode(int value) {
        this.value = value;
    }
}
