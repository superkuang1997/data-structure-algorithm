package test.structure.heap;

import base.structure.heap.MinHeap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by yorua
 * @description TODO
 * @date 2021/7/11 11:30
 */
public class MinHeapTest {
    public static void main(String[] args) {
        int[] nums = new int[]{18, 0, 5, 21, 9, 11, 14, 19, 33, 17, 27};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        MinHeap minHeap = new MinHeap(nums, nums.length);
        System.out.println(minHeap);
        minHeap.heapSort();
    }
}
