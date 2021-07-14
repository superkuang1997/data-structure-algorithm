package base.array;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author by yorua
 * @description topK问题
 * @date 2021/7/10 14:59
 */
@DisplayName("最小的K个数")
public class Offer40 {

    @Test
    public void testAll() {
        int k = 3;
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        test01(arr, k);
    }

    @Test
    @DisplayName("quick sort")
    public void test01(int[] arr, int k) {


    }

    @Test
    @DisplayName("heap")
    public void test02() {

    }


}
