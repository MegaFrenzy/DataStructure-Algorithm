package l6_sort;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-05 11:10
 */
public class S03Insert {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        insert2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        int insertVal, arrIndex, count = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            arrIndex = i - 1;
            while (arrIndex >= 0 && arr[arrIndex] > insertVal) {
                arr[arrIndex + 1] = arr[arrIndex];
                arrIndex--;
            }
            if (arrIndex + 1 != i) {
                arr[arrIndex + 1] = insertVal;
            }
            System.out.printf("第%d次排序%s\n", ++count, Arrays.toString(arr));
        }
    }

    public static void insert2(int[] arr) {
        int insertVal;
        for (int i = 1; i < arr.length; i++) {
            int insertIdx;
            for (insertIdx = 0; insertIdx < i; insertIdx++) {
                if (arr[i]<arr[insertIdx]) {
                    break;
                }
            }
            insertVal = arr[i];
            for (int j = i; j > insertIdx; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertIdx]=insertVal;
        }
    }

}


