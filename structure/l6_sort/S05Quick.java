package l6_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-06 10:02
 */
public class S05Quick {
    public static void main(String[] args) {
        int arr[] = {-9, 78, 0, 23, -57, 70, 80, -60};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        /*60万整型数选择排序耗时测试*/
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.printf("time before calc:%s\n",sdf.format(new Date()));
//        int[] arr0=new int[600000];
//        for (int i = 0; i < 600000; i++) {
//            arr0[i] = (int) (Math.random() * 600000);
//        }
//        quick(arr0,0,arr0.length-1);
//        System.out.printf("time before calc:%s\n",sdf.format(new Date()));
    }


    public static void quick(int[] arr,int leftBound,int rightBound){
        if(leftBound>=rightBound){
            return;
        }
        int pivotIndex = partition(arr,leftBound,rightBound);
        quick(arr,leftBound,pivotIndex-1);
        quick(arr,pivotIndex+1,rightBound);
    }
    private static int partition(int[] arr, int low, int high) {
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        int pivotValue=arr[pivotIndex];
        swap(arr,pivotIndex,high);
        int last=high--;
        //  2 3 1 8 7
        //  2 7 1 8     3
        //  2 8 1 7
        //  2 1 3 8 7
        while(low<=high){
            if(arr[low]>pivotValue){
                swap(arr,low,high);
                high--;
            }else{
                low++;
            }

        }
        swap(arr,low,last);
        return low;




    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
