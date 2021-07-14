package base.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author by yorua
 * @description TODO
 * @date 2021/7/10 16:17
 */
public class QuickSort {

    @Test
    public void test01() {
        int[] arr = new int[]{0, 1, 0, 1, 1};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void quicksort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    public static void partition(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i < hi && nums[i] < mid);
            while (--j > lo && nums[j] > mid);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        partition(nums, lo, j - 1);
        partition(nums, j + 1, hi);

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
