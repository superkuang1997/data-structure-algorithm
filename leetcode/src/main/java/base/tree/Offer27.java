package base.tree;


import base.structure.tree.TreeNode;
import base.utils.TreeFactory;

/**
 * @author by didi
 * @apiNote TODO
 * @date 2021/7/2 10:12 上午
 */
public class Offer27 {
    private static TreeNode root = TreeFactory.buildTree(4, 2, 7, 1, 3, 6, 9);

    public static void main(String[] args) {
        Offer27 question = new Offer27();
        TreeNode ans = question.mirrorTree(root);
        System.out.println(ans);
    }

    TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先定义root节点该做的事情，就是交换左右两棵树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 递归调用，让子节点也这样做
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

}
