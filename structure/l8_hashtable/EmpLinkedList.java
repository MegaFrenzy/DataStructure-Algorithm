package l8_hashtable;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 22:17
 */
public class EmpLinkedList {
    public Employee head = null;

    public void add(Employee e) {
        if (head == null) {
            head = e;
            return;
        }
        Employee cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = e;
    }

    public void list() {
        Employee cursor = head;
        if (null == head) {
            System.out.print("->\t空");
            return;
        }
        while (cursor != null) {
            System.out.printf("->\t%s", cursor);
            cursor = cursor.next;
        }
    }

    public Employee findEmpById(int id) {

        if (null == head) {
            return null;
        }
        Employee cursor = head;
        while (cursor != null) {
            if (id == cursor.id) {
                return cursor;
            }
            cursor = cursor.next;
        }
        return null;
    }

    public boolean delEmpById(int id) {
        if (null == head) {
            //System.out.println("empty list");
            return false;
        }
        if (id == head.id) {
            head = null;
            //System.out.println("delete succeed");
            return true;
        }

        Employee cursor = head.next;
        Employee temp = head;
        while (cursor != null) {
            if (id == cursor.id) {
                temp.next = cursor.next;
                cursor = null;
                //System.out.println("delete succeed");
                return true;
            }
            cursor = cursor.next;
            temp = temp.next;
        }
        //System.out.println("can not find");
        return false;
    }
}
