package base.structure.tree;

/**
 * @author by yorua
 * @classname AVLTreeNode
 * @description TODO
 * @date 2021/1/4 11:55 上午
 */
public class AVLTreeNode {
    private int key;
    private Object value;
    private AVLTreeNode leftChild;
    private AVLTreeNode rightChild;
    private AVLTreeNode parent;
    private int balanceFactor = 0;

    public AVLTreeNode(int key, Object value) {
        this.key = key;
        this.value = value;
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

    public AVLTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLTreeNode rightChild) {
        this.rightChild = rightChild;
    }


    public AVLTreeNode getParent() {
        return parent;
    }

    public void setParent(AVLTreeNode parent) {
        this.parent = parent;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasAnyChild() {
        return leftChild != null || rightChild != null;
    }

    public boolean hasBothChild() {
        return leftChild != null && rightChild != null;
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

    @Override
    public String toString() {
        return "AVLTreeNode{" +
                "key=" + key +
                ", value=" + value +
                ", balanceFactor=" + balanceFactor +
                '}';
    }
}
