package base.utils;


import base.structure.tree.TreeNode;

/**
 * @author by didi
 * @date 2021/7/2 10:14 上午
 */
public class TreeFactory {
    public static TreeNode buildTree(int a, int b, int c, int d, int e, int f, int g) {
        TreeNode A = new TreeNode(a);
        TreeNode B = new TreeNode(b);
        TreeNode C = new TreeNode(c);
        TreeNode D = new TreeNode(d);
        TreeNode E = new TreeNode(e);
        TreeNode F = new TreeNode(f);
        TreeNode G = new TreeNode(g);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        return A;
    }
}
