package l6_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-07 17:01
 */
public class S08Counting {
    public static void main(String[] args) {
        int[] arr = {105, 105, 115, 107, 108, 109,};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void countingSort(int[] arr) {
        int arrMax = arr[0], arrMin = arr[0];
        for (int ele : arr) {
            if (ele > arrMax)
                arrMax = ele;
            if (ele < arrMin)
                arrMin = ele;
        }
        int temp[] = new int[arrMax - arrMin + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - arrMin]++;
        }
        int arrIdx = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                arr[arrIdx++] = i + arrMin;
                temp[i]--;
            }
        }

    }

    public int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(20)-10;
        }
        return arr;
    }

    @Test
    public void testCount() {
        int[] a = generateRandomArray();
        countingSort(a);
        System.out.println(Arrays.toString(a));
    }
}
