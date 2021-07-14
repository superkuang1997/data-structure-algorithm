package base.algorithm.sort;

/**
 * @author by yorua
 * @classname bubbleSort
 * @description 冒泡排序
 * @date 2020/12/25 9:02 上午
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1, 8};
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {
        for (int passnum = array.length - 1; passnum > 0; passnum--) {
            for (int i = 0; i < passnum; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
