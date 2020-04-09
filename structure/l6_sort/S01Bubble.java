package l6_sort;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-04 21:44
 */
public class S01Bubble {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        System.out.println(Arrays.toString(arr));
        Bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Bubble(int[] arr) {
        int temp;
        int count = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            boolean bChange = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    bChange = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            count++;
            System.out.printf("第%d次结果为:%s\n", count, Arrays.toString(arr));
            if (bChange)
                break;
        }
    }

}
