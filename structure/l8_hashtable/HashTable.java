package l8_hashtable;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 22:31
 */
public class HashTable {
    private EmpLinkedList[] empListArray;
    private int size;

    public HashTable() {
        this.size = 7;
        empListArray = new EmpLinkedList[7];
        for (int i = 0; i < size; i++) {
            empListArray[i] = new EmpLinkedList();
        }
    }

    public HashTable(int size) {
        this.size = size;
        empListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Employee e) {
        int i = hashFun(e.id);
        empListArray[i].add(e);
    }

    public void list() {
        for (int i = 0; i < empListArray.length; i++) {
            System.out.print("第" + (i + 1) + "条链表内容为");
            empListArray[i].list();
            System.out.println();
        }
    }

    public void findEmpById(int id) {
        int i = hashFun(id);
        Employee e = empListArray[i].findEmpById(id);
        if (null != e) {
            System.out.println("在第" + (i + 1) + "条链表中找到该雇员" + e);
        } else {
            System.out.println("没有找到该雇员");
        }
    }

    public void delEmpById(int id) {
        int i = hashFun(id);
        boolean b = empListArray[i].delEmpById(id);
        if(b)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }

    private int hashFun(int id) {
        return id % size;
    }
}
