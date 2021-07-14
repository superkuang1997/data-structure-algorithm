package base.algorithm.sort;

import java.util.Arrays;

/**
 * @author by yorua
 * @classname selectSort
 * @description 选择排序 冒泡排序的改进版
 * @date 2020/12/25 9:59 上午
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1, 8};
        selectSortImplement(array);
    }

    public static void selectSortImplement(int[] array) {
        int passnum = array.length - 1;
        while (passnum > 0) {
            int indexOfMax = 0;
            for (int i = 1; i <= passnum; i++) {
                if (array[i] > array[indexOfMax]) {
                    indexOfMax = i;
                }
            }
            int temp = array[indexOfMax];
            array[indexOfMax] = array[passnum];
            array[passnum] = temp;
            passnum--;
        }
        System.out.println(Arrays.toString(array));
    }
}

