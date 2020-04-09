package l3_linkedlist.llinkedList03Double;

import l3_linkedlist.Hero;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-01 21:12
 */
public class Demo03 {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        DoubleLinkedList dl1 = new DoubleLinkedList();


        HeroNode h1 = new HeroNode(new Hero(1, "宋江", "及时雨"));
        HeroNode h2 = new HeroNode(new Hero(2, "卢俊义", "玉麒麟"));
        HeroNode h3 = new HeroNode(new Hero(3, "吴用", "智多星"));
        HeroNode h4 = new HeroNode(new Hero(4, "林冲", "豹子头"));

        dl1.addByOrder(h4);
        dl1.addByOrder(h1);
        dl1.addByOrder(h3);
        dl1.addByOrder(new HeroNode(new Hero(5, "鲁智深", "花和尚")));
        dl1.addByOrder(h2);
//        dl1.delete(3);

        dl1.list();
    }
}
