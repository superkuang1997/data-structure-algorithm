package base.structure.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author by didi
 * @apiNote TODO
 * @date 2021/7/1 10:23 上午
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "base.structure.tree.TreeNode{" +
                "val=" + val +
                ", left=" + left.val +
                ", right=" + right.val +
                '}';
    }

    /**
     * 层序遍历的方式打印树结构
     */
    public void pretty() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                else {
                    queue.offer(null);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                else {
                    queue.offer(null);
                }
            }
            else {
                sb.append("null").append(",");
            }

        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());
    }
}
