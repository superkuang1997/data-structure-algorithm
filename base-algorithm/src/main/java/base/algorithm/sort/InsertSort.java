package base.algorithm.sort;

import java.util.Arrays;

/**
 * @author by yorua
 * @classname InsertSort
 * @description TODO
 * @date 2020/12/25 10:34 上午
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pos = i;
            int cur = array[pos];
            while (pos > 0 && array[pos - 1] > cur) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = cur;
        }
    }

}
