package base.structure.heap;

import java.util.Arrays;

/**
 * @author by yorua
 * @description 小根堆的实现
 * @date 2021/7/10 17:53
 */
public class MinHeap {

    /**
     * 将所有元素以完全二叉树的形式存入数组
     */
    private final int[] heap;

    /**
     * 堆中元素的个数
     */
    private int curSize;

    public MinHeap(int curSize) {
        heap = new int[curSize];
    }

    public MinHeap(int[] nums, int maxSize) {
        heap = new int[Math.max(maxSize, nums.length)];
        System.arraycopy(nums, 0, heap, 0, nums.length);
        curSize = heap.length;
        // 从最后一个节点的父节点开始下沉，叶节点无需下沉
        int pos = (curSize - 2) / 2;
        while (pos >= 0) {
            shiftDown(pos);
            pos--;
        }
    }


    /**
     * 从最后一个节点上浮 插入新元素后，新元素处于数组最后的位置，即索引为 size - 1
     *
     * @param i 开始上浮的索引
     */
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
    private void shiftDown(int i) {
        // 当前节点的左子节点索引小于等于最后一个节点索引，说明还有下沉的空间
        while (2 * i + 1 <= curSize - 1) {
            int smallerChild = getSmallerChild(i);
            if (heap[i] > heap[smallerChild]) {
                swap(heap, i, smallerChild);
            }
            i = smallerChild;
        }
    }

    public void insert(int num) {
        if (curSize < heap.length) {
            heap[curSize++] = num;
            shiftUp(0);
        }
    }

    public void del() {
        if (curSize > 0) {
            // 删除堆顶元素，并将堆尾元素回填到堆顶
            heap[0] = heap[curSize - 1];
            curSize--;
            // 下沉
            shiftDown(0);

        }
    }


    /**
     * 返回较小子节点的索引
     *
     * @param i 父节点的索引
     * @return 较小子节点的索引
     */
    private int getSmallerChild(int i) {
        // 如果没有右子节点，则直接返回左子节点。
        if (2 * i + 2 > curSize - 1) {
            return 2 * i + 1;
        }
        // 如果都有，则返回其中较小的一个
        else {
            return heap[2 * i + 1] < heap[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
        }
    }
    /**
     * 小根堆 堆排序之后的结果是逆序
     */
    public void heapSort() {
        int size = curSize;
        for (int i = 0; i < size; i++) {
            swap(heap, 0, curSize - 1);
            curSize--;
            shiftDown(0);
        }
        System.out.println(Arrays.toString(heap));
    }

    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "heap=" + Arrays.toString(Arrays.copyOf(heap, curSize)) +
                ", curSize=" + curSize +
                '}';
    }

}
