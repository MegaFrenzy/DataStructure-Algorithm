package l8_hashtable;

import java.util.Scanner;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 23:36
 */
public class Demo {
    public static void main(String[] args) {
        HashTable ht = new HashTable(7);
        Scanner scanner = new Scanner(System.in);
        String str = "";
        boolean flag = true;
        while (flag) {
            System.out.println("a:add");
            System.out.println("l:list");
            System.out.println("e:exit");
            System.out.println("d:delete");
            System.out.println("f:find");
            str = scanner.next();
            switch (str) {
                case "a":
                    System.out.println("please input id");
                    int id = scanner.nextInt();
                    System.out.println("please input name");
                    String name = scanner.next();
                    ht.add(new Employee(id, name));
                    break;
                case "l":
                    ht.list();
                    break;
                case "f":
                    System.out.println("please input id to find");
                    int findId = scanner.nextInt();
                    ht.findEmpById(findId);
                    break;
                case "d":
                    System.out.println("please input id to delete");
                    int deleteId = scanner.nextInt();
                    ht.delEmpById(deleteId);
                    break;
                case "e":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
