package test.structure.heap;

import base.structure.heap.MaxHeap;
import base.structure.heap.MinHeap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by yorua
 * @description TODO
 * @date 2021/7/11 11:30
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 5, 9, 11, 14, 18, 19, 21, 33, 17, 27};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        MaxHeap maxHeap = new MaxHeap(nums, nums.length);
        System.out.println(maxHeap);
        maxHeap.heapSort();
    }
}
