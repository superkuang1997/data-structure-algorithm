package base.algorithm.sort;

import java.util.Arrays;

/**
 * @author by yorua
 * @description 堆排序
 * @date 2021/7/10 17:28
 */
public class HeapSort {
    static int[] heap;
    static int curSize;

    public static void main(String[] args) {
        int[] nums = new int[]{0, 5, 9, 11, 14, 18, 19, 21, 33, 17, 27};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 小根堆堆排序之后的结果是逆序
     * @param nums 未排序的数组
     */
    public static void heapSort(int[] nums) {
        heap = nums;
        curSize = nums.length;
        // 建堆
        int pos = (curSize - 2) / 2;
        while (pos >= 0) {
            shiftDown(pos);
            pos--;
        }
        // 堆排序
        for (int i = 0; i < nums.length; i++) {
            swap(heap, 0, curSize - 1);
            curSize--;
            shiftDown(0);
        }
    }

    private void shiftUp(int i) {
        //  如果存在父节点
        while ((i - 1) / 2 >= 0 && i != 0) {
            if (heap[i] < heap[(i - 1) / 2]) {
                swap(heap, i, (i - 1) / 2);
            }
            else {
                break;
            }
            i = (i - 1) / 2;
        }
    }

    /**
     * 从某个节点下沉
     *
     * @param i 节点索引
     */
    private static void shiftDown(int i) {
        // 当前节点的左子节点索引小于等于最后一个节点索引，说明还有下沉的空间
        while (2 * i + 1 <= curSize - 1) {
            int smallerChild = getSmallerChild(i);
            if (heap[i] > heap[smallerChild]) {
                swap(heap, i, smallerChild);
            }
            i = smallerChild;
        }
    }

    private static int getSmallerChild(int i) {
        // 如果没有右子节点，则直接返回左子节点。
        if (2 * i + 2 > curSize - 1) {
            return 2 * i + 1;
        }
        // 如果都有，则返回其中较小的一个
        else {
            return heap[2 * i + 1] < heap[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
        }
    }

    private static void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

}
