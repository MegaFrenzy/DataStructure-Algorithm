package l3_linkedlist.linkedList02SingleCircle;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-02 10:24
 */
public class Demo02 {
    public static void main(String[] args) {
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        for (int i = 1; i < 6; i++) {
            ListNode node = new ListNode(i);
            list.add(node);
        }
        list.print();


    }
}
