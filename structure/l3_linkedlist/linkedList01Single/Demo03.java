package l3_linkedlist.linkedList01Single;

import l3_linkedlist.Hero;
import org.junit.Test;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-02-29 23:55
 */
public class Demo03 {
    public static void main(String[] args) {
        SingleLinkedList l1= new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));
        l1.addByOrder(heroNode1);
        l1.addByOrder(heroNode4);
        l1.addByOrder(heroNode2);
        l1.addByOrder(heroNode3);
        //l1.list();

        HeroNode newHeroNode = new HeroNode(new Hero(2, "卢22", "玉22"));
        l1.Update(newHeroNode);
        l1.list();

        l1.delete(1);
        l1.list();

        int length = l1.getLength(l1.getHead());
        System.out.println("length = " + length);

//        HeroNode node = SingleLinkedListExer.getBackIdxNode(l1.getHead(), 3);
//        System.out.println(node);

        SingleLinkedListExer.reverse(l1.getHead());
        l1.list();

    }
    @Test
    public void test1(){
        SingleLinkedList l1= new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode4 = new HeroNode(new Hero(4, "林冲", "豹子头"));
        l1.add(heroNode1);
        l1.add(heroNode2);
        l1.add(heroNode3);
        l1.add(heroNode4);
        l1.add(new HeroNode(new Hero(6, "程咬金", "厨子")));


        HeroNode heroNode5 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode heroNode6 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode heroNode7 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode heroNode8 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        SingleLinkedList l2 = new SingleLinkedList();
        l2.addByOrder(heroNode5);
        l2.addByOrder(heroNode6);
        //l2.addByOrder(heroNode7);
        //l2.addByOrder(heroNode8);

        HeroNode l0 = SingleLinkedListExer.mergeList(l1.getHead(), l2.getHead());

        HeroNode temp =l0;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }


    }
}
