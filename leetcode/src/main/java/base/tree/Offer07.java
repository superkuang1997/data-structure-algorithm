package base.tree;

import base.structure.tree.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author by yorua
 * @classname Offer07
 * @description 重建二叉树
 * @date 2021/7/5 21:04
 */
@DisplayName("重建二叉树")
public class Offer07 {
    static Offer07 problem;

    @BeforeAll
    public static void before() {
        problem = new Offer07();
    }

    @Test
    public void case01() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        problem.buildTree(preorder, inorder).pretty();
    }

    @Test
    public void case02() {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        problem.buildTree(preorder, inorder).pretty();

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 重建二叉树，返回根节点
     */
    private TreeNode dfs(int[] preorder, int p1, int p2,
                         int[] inorder, int i1, int i2) {
        if (p1 == p2) return new TreeNode(preorder[p1]);
        if (p1 > p2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        int idx = -1;
        while (root.val != inorder[++idx]) ;
        int leftNum = idx - i1, rightNum = i2 - idx;
        // 左子树递归
        root.left = dfs(preorder, p1 + 1, p1 + leftNum,
                inorder, i1, i1 + leftNum - 1);
        // 右子树递归
        root.right = dfs(preorder, p1 + 1 + leftNum, p2,
                inorder, idx + 1, idx + rightNum);
        return root;
    }
}
