package base.tree;


import base.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by yorua
 * @description TODO
 * @date 2021/7/4 15:56
 */
public class Offer34 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(4);
        TreeNode C = new TreeNode(8);
        TreeNode D = new TreeNode(11);
        TreeNode E = new TreeNode(13);
        TreeNode F = new TreeNode(4);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(2);
        TreeNode I = new TreeNode(5);
        TreeNode J = new TreeNode(1);
        A.left = B;
        B.right = C;
        B.left = D;
        D.left = G;
        D.right = H;
        C.left = E;
        C.right = F;
        F.left = I;
        F.right = J;
        Offer34 problem = new Offer34();
        problem.pathSum(A, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null || target < root.val) return;
        path.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
        path.remove(path.size() - 1);
    }
}
