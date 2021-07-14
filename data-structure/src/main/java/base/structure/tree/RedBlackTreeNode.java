package base.structure.tree;

/**
 * @author by yorua
 * @classname RedBlackTreeNode
 * @description 红黑树的节点
 * @date 2021/1/4 12:02 下午
 */
public class RedBlackTreeNode {
    private int key;
    private Object value;
    private RedBlackTreeNode leftChild;
    private RedBlackTreeNode rightChild;
    private RedBlackTreeNode parent;
    /**
     * RED = true，BLACK = false
     */
    private boolean color;

    public RedBlackTreeNode(int key, Object value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public RedBlackTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean isLeftChild() {
        return parent != null && parent.leftChild == this;
    }

    public boolean isRightChild() {
        return parent != null && parent.rightChild == this;
    }

    public boolean hasUncle() {
        RedBlackTreeNode parent = this.getParent();
        RedBlackTreeNode grandParent = parent.getParent();
        if (parent.isLeftChild()) {
            return grandParent.hasRightChild();
        } else {
            return grandParent.hasLeftChild();
        }
    }

    public RedBlackTreeNode getUncle() {
        RedBlackTreeNode parent = this.getParent();
        RedBlackTreeNode grandParent = parent.getParent();
        if (parent.isLeftChild()) {
            return grandParent.getRightChild();
        } else {
            return grandParent.getLeftChild();
        }
    }

    public boolean uncleIsRed() {
        return hasUncle() && getUncle().getColor();
    }

    public String colorOf(boolean b) {
        return b ? "Red" : "Black";
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" +
                "key=" + getKey() +
                ", value=" + getValue() +
                ", color=" + colorOf(color) +
                '}';
    }
}
