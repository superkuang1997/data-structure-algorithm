package base.algorithm.sort;


import java.util.Arrays;

/**
 * @author by yorua
 * @description 归并排序
 * @date 2020/12/25 4:14 下午
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] list = new int[]{5, 3, 7, 2, 10, 1, 0, 4, 6, 8};
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }


    public static void mergeSort(int[] list) {
        // 递归结束条件 list.length == 1
        if (list.length == 1) {
            return;
        }

        int mid = list.length / 2;
        // 分裂，并调用自身
        int[] left = Arrays.copyOfRange(list, 0, mid);
        int[] right = Arrays.copyOfRange(list, mid, list.length);
        mergeSort(left);
        mergeSort(right);

        // 左分支计数器
        int i = 0;
        // 右分支计数器
        int j = 0;
        // 整体归并计数器
        int k = 0;

        // 归并
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        // 处理余项
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }

    }
}
