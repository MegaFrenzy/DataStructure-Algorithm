package l6_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-05 10:26
 */
public class S02Select {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        select(arr);
        System.out.println(Arrays.toString(arr));

        /*8万整型数选择排序耗时测试*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("time before calc:%s\n",sdf.format(new Date()));
        int[] arr0=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr0[i] = (int) (Math.random() * 80000);
        }
        select(arr0);
        System.out.printf("time before calc:%s\n",sdf.format(new Date()));*/
    }

    public static void select(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minVal = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            if(minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }
        }


    }
}
