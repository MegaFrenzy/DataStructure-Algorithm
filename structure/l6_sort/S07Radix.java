package l6_sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-07 11:28
 */
public class S07Radix {
    public static void main(String[] args) {
        int[] arr = {92, 123, 845, 616, 574, 74, 51, 30, 2};
        radix(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radix(int[] arr) {

        int[][] bucket = new int[10][arr.length];
        int[] bktDepth = new int[10];

        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) maxVal = arr[i];
        }
        int maxLen = (maxVal + "").length();

        for (int l = 0; l < maxLen; l++) {
            int div = (int) Math.pow(10, l);
            for (int i = 0; i < arr.length; i++) {
                int bktPlace = arr[i] / div % 10;
                bucket[bktPlace][bktDepth[bktPlace]++] = arr[i];
            }
            int arrIndex = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bktDepth[i]; j++) {
                    arr[arrIndex++] = bucket[i][j];
                }
                bktDepth[i] = 0;
            }
        }


    }
    //mashibing:创建一维数组通过构造count数组实现对arr的迭代
    public static int[] sort(int[] arr) {
        int[] res = new int[arr.length];
        int[] count = new int[10];
        int countIdx;
        for (int i = 0; i < 3; i++) {
            int div = (int) Math.pow(10, i);
            for (int j = 0; j < arr.length; j++) {
                countIdx=arr[j] / div % 10;
                count[countIdx]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j]=count[j-1]+count[j];
            }
            for (int j = arr.length - 1; j >= 0 ; j--) {
                countIdx=arr[j] / div % 10;
                res[--count[countIdx]]=arr[j];
            }


            System.arraycopy(res, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);

        }
        return res;
    }
}
