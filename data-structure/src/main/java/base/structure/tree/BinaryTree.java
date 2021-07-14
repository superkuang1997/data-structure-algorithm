package base.structure.tree;

/**
 * @author by yorua
 * @classname BinaryTreeLinked
 * @description 二叉树，底层采用链表实现
 * @date 2020/12/27 9:44 上午
 */
public class BinaryTree {
    private final Object root;
    private BinaryTree leftBranch;
    private BinaryTree rightBranch;

    public BinaryTree(Object root) {
        this.root = root;
        this.leftBranch = null;
        this.rightBranch = null;
    }

    public static void preOrder(BinaryTree tree) {
        if (tree != null) {
            System.out.println(tree.getRoot());
            preOrder(tree.getLeftBranch());
            preOrder(tree.getRightBranch());
        }
    }

    public static void inOrder(BinaryTree tree) {
        if (tree != null) {
            inOrder(tree.getLeftBranch());
            System.out.println(tree.getRoot());
            inOrder(tree.getRightBranch());
        }
    }

    public static void postOrder(BinaryTree tree) {
        if (tree != null) {
            postOrder(tree.getLeftBranch());
            postOrder(tree.getRightBranch());
            System.out.println(tree.getRoot());
        }
    }

    public void insertLeft(Object nodeValue) {
        if (this.leftBranch == null) {
            this.leftBranch = new BinaryTree(nodeValue);
        } else {
            BinaryTree temp = new BinaryTree(nodeValue);
            temp.leftBranch = this.leftBranch;
            this.leftBranch = temp;
        }
    }

    public void insertRight(Object nodeValue) {
        if (this.rightBranch == null) {
            this.rightBranch = new BinaryTree(nodeValue);
        } else {
            BinaryTree temp = new BinaryTree(nodeValue);
            temp.rightBranch = this.rightBranch;
            this.rightBranch = temp;
        }
    }

    public Object getRoot() {
        return root;
    }

    public BinaryTree getLeftBranch() {
        return leftBranch;
    }

    public BinaryTree getRightBranch() {
        return rightBranch;
    }
}
