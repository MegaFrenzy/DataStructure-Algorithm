package ignore;

import javax.xml.soap.Text;
import java.util.*;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-05-30 20:22
 */
public class TextHandle {
    public static void main(String[] args) {
        reg();
        //getInfo();

        TextHandle t = new TextHandle();
        t.getPermutation(3,3);
        ArrayList<Object> objects = new ArrayList<>();


//        String s = " ";
//        char ch = s.charAt(0);
//        String ss = "112";
//        System.out.println(ss + 3);
//        System.out.println("+" + ch + "+");
//        String substring = "abc".substring(1, 1);
//        System.out.println("+" + substring + "+");
//        HashSet<Integer> set = new HashSet<>();
//        boolean add = set.add(4);
//        StringBuilder sb = new StringBuilder();
//
//        System.out.println(Integer.bitCount(5));
//        System.out.println(Integer.parseInt("0")+"=="+Integer.parseInt("01"));

    }


    private static void reg() {
        char[] c = new char[4];
        c[0] = 'A';
        c[1] = '8';
        c[2] = '5';
        c[3] = '3';
        String s = Arrays.toString(c);
        System.out.println(s);

        String s1 = String.valueOf(c,0,4);
        System.out.println(s1);
    }

    private List<String> list;
    private boolean[] visited;
    public String getPermutation(int n, int k) {
        list = new ArrayList<String>();
        visited = new boolean[n + 1];
        helper(0, n, "");
        return list.get(k - 1);
    }
    private void helper(int depth, int n, String s) {
        if (depth == n) {
            list.add(new String(s));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            helper(depth + 1, n, s + i);
            visited[i] = false;
        }
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
