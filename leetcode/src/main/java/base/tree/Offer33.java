package base.tree;

/**
 * @author by yorua
 * @classname Offer33
 * @description TODO
 * @date 2021/7/4 14:32
 */
public class Offer33 {

    public static void main(String[] args) {
        Offer33 problem = new Offer33();
        problem.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3});
    }

    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder, 0, postorder.length - 1);


    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int root = postorder[j];
        int idx = i - 1;
        while (postorder[++idx] < root) ;
        for (int k = idx + 1; k < j; k++) {
            if (postorder[k] < root) return false;
        }
        return recur(postorder, i, idx - 1) && recur(postorder, idx, j - 1);

    }
}
