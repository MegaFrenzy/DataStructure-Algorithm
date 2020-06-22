package ignore;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-30 20:22
 */
public class TextHandle {
    public static void main(String[] args) {
        getInfo();
    }
    private static void mapping() {//先传对应关系，后输出地CAN址
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if ("###".equals(s)) break;
            if (s.length() != 0) {
                int end1 = s.indexOf("0x") - 1;
                map.put(s.substring(0, end1), s.substring(end1 + 1));
            }
        }
        System.out.println("output-------");
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(map.get(s));
        }
    }

    private static void check() {//检测输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() != 0) {
                System.out.println("get->" + s);
            }
        }
    }

    private static void getInfo() {//根据codesys初始化代码段获取位移值
        Scanner sc = new Scanner(System.in);
        int x = 1;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() != 0) {
                String stat = x == 1 ? "Extend" : "Retract";
                x = 1 - x;
                int nameStart = -1;
                nameStart = s.indexOf(".", nameStart + 1);
                nameStart = s.indexOf(".", nameStart + 1);
                int nameEnd = s.indexOf(".", nameStart + 1);
                System.out.print(s.substring(nameStart + 1, nameEnd) + "\t");
                System.out.print(stat + "\t");
                int i = s.indexOf(":=") + 2;
                int j = s.indexOf(";");
                System.out.println(s.substring(i, j));
            }
        }
    }

    private static void getAddr() {//CAN地址转换输出
        Scanner sc = new Scanner(System.in);
        String base = null;
        String offset = null;
        int add = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() != 0) {
                if (s.startsWith("0x")) {
                    base = s.substring(0, 6);
                    add = 1;
                }
                if (s.contains("\"D")) {
                    System.out.println(base + ":byte" + add + "-" + (add + 1)
                            + "\t" + s.substring(s.indexOf("\"D") + 1));
                    add += 2;
                }
            }
        }
    }

    private static void getName() {//根据型号输出中文名
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() != 0) {
                StringBuilder res = new StringBuilder();
                res.append(s.substring(1, 3));
                res.append("#");
                if (s.contains("Q")) res.append("驱动");
                else res.append("辅助");
                if (s.endsWith("1")) res.append('1');
                if (s.endsWith("2")) res.append('2');
                res.append("插销");
                System.out.println(res);
            }
        }
    }

}
