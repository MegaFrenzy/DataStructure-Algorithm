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
        build_heap(tree, tree.length);  //对新数据构建堆
        for (int i = tree.length - 1; i >= 0; i--) {    //每次循环把0-i中最大的放到该范围内的最后面，再去处理前面0~i-1号
            swap(tree, i, 0);   //对于已经构建好的最大堆，每次把0号最大和第i号交换表示：只需处理剩下i个数的序列
            build_heap(tree, i);     //对剩下i+1个数进行堆排序
        }
    }

    public static void build_heap(int[] tree, int n) {  //传入数组长度n
        int last_node = n - 1;                          //根据数组最后一个元素的索引结点获取其父结点
        int parent = (last_node - 1) / 2;               //parentIdx = (childIdx - 1) / 2;
        for (int i = parent; i >= 0; i--) {             //对parentIdx到0进行heapify
            heapify(tree, n, i);
        }
    }

    public static void heapify(int[] tree, int boundIdx, int index) {   //boundIdx是要heapify的长度
        if (index >= boundIdx)                                          //越界返回
            return;
        int c1Index = index * 2 + 1;    //2个孩子结点的索引
        int c2Index = index * 2 + 2;
        int maxVIndex = index;          //假设最大值为当前结点
        if (c1Index < boundIdx && tree[c1Index] > tree[maxVIndex]) {    //有孩子结点的值比该结点值大，则进行交换
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
