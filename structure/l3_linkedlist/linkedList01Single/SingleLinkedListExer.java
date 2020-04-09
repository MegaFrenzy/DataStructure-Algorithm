package l3_linkedlist.linkedList01Single;

import l3_linkedlist.Hero;

import java.util.Stack;

/**
 * @Description: 单链表练习
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-01 10:48
 */
public class SingleLinkedListExer {
    /**
     * 获取单链表中的倒数第k个结点
     *
     * @param head      单链表头结点
     * @param backIndex 倒数节点索引，从1开始,
     * @return
     */
    public static HeroNode getBackIdxNode(HeroNode head, int backIndex) {
        if (head == null || head.next == null || backIndex <= 0)
            return null;

        int length = 0;
        HeroNode cursor = head;
        while (cursor.hasNext()) {
            length++;
            cursor = cursor.next;
        }
        if (length < backIndex) {
            return null;
        }
        cursor = head.next;
        for (int i = length - backIndex; i > 0; i--) {
            cursor = cursor.next;
        }
        return cursor;

        //{
        //        int headIndex=(length-backIndex>=0)?(length-backIndex):-1;
        //        cursor=head.next;
        //        while(headIndex>0){
        //            cursor=cursor.next;
        //            headIndex--;
        //        }
        //        return cursor==head?null:cursor;}
    }

    /**
     * 将传入的单链表进行反转
     *
     * @param head:要反转链表的头结点
     */
    public static void reverse(HeroNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        HeroNode cursor = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode();
        HeroNode rCursor = reverseHead;
        while (cursor != null) {
            next = cursor.next;
            cursor.next = rCursor.next;
            rCursor.next = cursor;
            cursor = next;
        }
        head.next = reverseHead.next;

    }

    public static void reverse2(HeroNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode();
        HeroNode temp;
        while (head.next != null) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;

        }


    }

    public static void printReverseList(HeroNode head) {
        if (head == null || head.next == null) {
            return;
        }
        printReverseList(head.next);
        System.out.println(head.next.hero);
    }

    public static void printReverseList2(HeroNode head) {
        if (head == null || head.next == null)
            return;
        Stack<Hero> hero = new Stack<>();
        HeroNode cursor = head;
        while (cursor.hasNext()) {
            cursor = cursor.next;
            hero.push(cursor.hero);
        }
        while (!hero.empty()) {
            System.out.println(hero.pop());
        }

    }

    public static HeroNode mergeList(HeroNode h1, HeroNode h2) {
        if(h1==null||h2==null)
            return null;
        HeroNode nodes = new HeroNode();
        HeroNode temp;
        HeroNode nodesTail=nodes;
        while(h1.next!=null&&h2.next!=null){
            if(h1.next.hero.no<h2.next.hero.no){
                temp =h1.next;
                h1.next=h1.next.next;
                temp.next=null;
                nodesTail.next=temp;
                nodesTail=nodesTail.next;
            }else{
                temp =h2.next;
                h2.next=h2.next.next;
                temp.next=null;
                nodesTail.next=temp;
                nodesTail=nodesTail.next;
            }
        }
        if(h1.next==null){
            nodesTail.next=h2.next;
        }
        if(h2.next==null){
            nodesTail.next=h1.next;
        }

        return nodes;
    }


}
