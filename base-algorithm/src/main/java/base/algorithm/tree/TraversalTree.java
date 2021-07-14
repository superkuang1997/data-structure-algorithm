package base.algorithm.tree;


import base.structure.tree.TreeNode;
import base.utils.TreeFactory;

/**
 * @author by didi
 * @date 2021/7/2 9:33 上午
 */
public class TraversalTree {

    public static void main(String[] args) {
        TreeNode root = TreeFactory.buildTree(1, 2, 3, 4, 5, 6, 7);
        preorderTree(root);
    }

    public static void preorderTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTree(root.left);
            preorderTree(root.right);
        }
    }

    public static void inorderTree(TreeNode root) {
        if (root != null) {
            preorderTree(root.left);
            System.out.println(root.val);
            preorderTree(root.right);
        }
    }

    public static void postorderTree(TreeNode root) {
        if (root != null) {
            preorderTree(root.left);
            preorderTree(root.right);
            System.out.println(root.val);
        }
    }

}
