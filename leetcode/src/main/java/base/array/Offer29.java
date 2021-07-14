package base.array;

/**
 * @description TODO
 * @author by yorua
 * @date 2021/7/6 09:22
 */
public class Offer29 {
    public static void main(String[] args) {
        Offer29 problem = new Offer29();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        problem.spiralOrder(matrix);

    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        if (m == 0 || n == 0) return res;
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; i++) res[idx++] = matrix[top][i];
            if (++top >= bottom) break;
            for (int i = top; i <= bottom; i++) res[idx++] = matrix[i][right];
            if (--right <= left) break;
            for (int i = right; i >= left; i--) res[idx++] = matrix[bottom][i];
            if (--bottom <= top) break;
            for (int i = bottom; i >= top; i--) res[idx++] = matrix[i][left];
            if (++left >= right) break;
        }
        return res;
    }
}
