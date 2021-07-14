package base.algorithm.sort;

import java.util.Arrays;

/**
 * @author by yorua
 * @classname ShellSort
 * @description 希尔排序
 * @date 2020/12/25 10:54 上午
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] list = new int[]{5, 3, 7, 2, 1, 0, 4, 6, 8};
        shellSort(list);
    }

    public static void shellSort(int[] list) {
        int subListCount = list.length / 2;
        while (subListCount > 0) {
            for (int start = 0; start < subListCount; start++) {
                insertSortWithGap(list, start, subListCount);
            }
            subListCount /= 2;
        }
        System.out.println(Arrays.toString(list));
    }

    public static void insertSortWithGap(int[] list, int start, int gap) {
        for (int i = start; i < list.length; i += gap) {
            int position = i;
            int currentValue = list[position];
            while (position > start && list[position - gap] > currentValue) {
                list[position] = list[position - gap];
                position -= gap;
            }
            list[position] = currentValue;
        }
    }
}
