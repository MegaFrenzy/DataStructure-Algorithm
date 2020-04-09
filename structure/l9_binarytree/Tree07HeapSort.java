package l9_binarytree;

import java.util.Arrays;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-13 15:40
 */
public class Tree07HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1, 10, 4};
        //heapify(arr, arr.length,0);
        //build_heap(arr, arr.length);
        heap_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heap_sort(int[] tree) {
        build_heap(tree, tree.length);
        for (int i = tree.length - 1; i >= 0; i--) {
            swap(tree, i, 0);
            build_heap(tree,i);
        }
    }

    public static void build_heap(int[] tree, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public static void heapify(int[] tree, int boundIdx, int index) {
        if (index >= boundIdx)
            return;
        int c1Index = index * 2 + 1;
        int c2Index = index * 2 + 2;
        int maxVIndex = index;
        if (c1Index < boundIdx && tree[c1Index] > tree[maxVIndex]) {
            maxVIndex = c1Index;
        }
        if (c2Index < boundIdx && tree[c2Index] > tree[maxVIndex]) {
            maxVIndex = c2Index;
        }
        if (maxVIndex != index) {
            swap(tree, maxVIndex, index);
            heapify(tree, boundIdx, maxVIndex);
        }

    }

    public static void swap(int[] tree, int aIdx, int bIdx) {
        int temp = tree[aIdx];
        tree[aIdx] = tree[bIdx];
        tree[bIdx] = temp;
    }
}
