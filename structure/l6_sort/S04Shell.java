package l6_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-05 18:41
 */
public class S04Shell {

    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellMove(arr);
        System.out.println(Arrays.toString(arr));

        /*60万整型数选择排序耗时测试*/
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.printf("time before calc:%s\n",sdf.format(new Date()));
//        int[] arr0=new int[600000];
//        for (int i = 0; i < 600000; i++) {
//            arr0[i] = (int) (Math.random() * 600000);
//        }
//        shellMove(arr0);
//        System.out.printf("time before calc:%s\n",sdf.format(new Date()));
    }
    public static void shellMove(int[] arr) {
        int count = 0;
        int insertVal = 0;
        int insertIndex = 0;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex=i;
                insertVal=arr[i];
                while(insertIndex-gap>=0&&arr[insertIndex-gap]>insertVal){
                    arr[insertIndex]=arr[insertIndex-gap];
                    insertIndex-=gap;
                }
                arr[insertIndex]=insertVal;
            }
            System.out.printf("希尔排序第%d轮=%s\n", ++count, Arrays.toString(arr));
        }


    }
    public static void shellSwap(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j - gap >= 0; j -= gap) {
                    if (arr[j - gap] > arr[j]) {
                        temp = arr[j - gap];
                        arr[j - gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.printf("希尔排序第%d轮=%s\n", ++count, Arrays.toString(arr));
        }


    }


}
