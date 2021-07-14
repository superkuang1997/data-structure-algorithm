package base.structure.tree;


/**
 * @author by yorua
 * @classname AVLTree
 * @description AVL树
 * @date 2020/12/27 5:10 下午
 */
public class AVLTree {

    int currentSize = 0;
    private AVLTreeNode root;

    public AVLTreeNode getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            preOrder(root);
        }
        System.out.println("the length of test.tree is " + currentSize + ".");
    }

    public void preOrder(AVLTreeNode current) {
        System.out.println(current);
        if (current.getLeftChild() != null) {
            preOrder(current.getLeftChild());
        }
        if (current.getRightChild() != null) {
            preOrder(current.getRightChild());
        }
    }

    public void put(int key, Object value) {
        if (root != null) {
            put(key, value, root);
        } else {
            root = new AVLTreeNode(key, value);
        }
        currentSize++;
    }

    public void put(int key, Object value, AVLTreeNode currentNode) {
        if (key < currentNode.getKey()) {
            // 向左子树下放
            if (currentNode.hasLeftChild()) {
                put(key, value, currentNode.getLeftChild());
            } else {
                AVLTreeNode newNode = new AVLTreeNode(key, value);
                currentNode.setLeftChild(newNode);
                newNode.setParent(currentNode);
                // 对新插入节点造成的影响重新平衡
                updateBalance(newNode);

            }
        } else {
            // 向右子树下放
            if (currentNode.hasRightChild()) {
                put(key, value, currentNode.getRightChild());
            } else {
                AVLTreeNode newNode = new AVLTreeNode(key, value);
                currentNode.setRightChild(newNode);
                newNode.setParent(currentNode);
                // 对新插入节点造成的影响重新平衡
                updateBalance(newNode);
            }
        }
    }

    public void updateBalance(AVLTreeNode node) {
        if (node.getBalanceFactor() > 1 || node.getBalanceFactor() < -1) {
            rebalance(node);
            return;
        }
        AVLTreeNode parent = node.getParent();
        if (parent != null) {
            if (node.isLeftChild()) {
                parent.setBalanceFactor(parent.getBalanceFactor() + 1);
            } else if (node.isRightChild()) {
                parent.setBalanceFactor(parent.getBalanceFactor() - 1);
            }

            if (parent.getBalanceFactor() != 0) {
                updateBalance(parent);
            }
        }
    }

    /**
     * 调用rebalance操作的节点必定是平衡因子为2或者-2
     *
     * @param node
     */
    public void rebalance(AVLTreeNode node) {
        if (node.getBalanceFactor() > 0) {
            if (node.getLeftChild().getBalanceFactor() < 0) {
                // 当前节点左重，且当前节点的左子节点右重，应该先令左子节点左旋
                rotateLeft(node.getRightChild());
            }
            // 当前节点右旋
            rotateRight(node);

        } else if (node.getBalanceFactor() < 0) {

            if (node.getRightChild().getBalanceFactor() > 0) {
                // 当前节点右重，且当前节点的右子节点左重，应该先令右子节点右旋
                rotateRight(node.getRightChild());
            }
            // 当前节点左旋
            rotateLeft(node);
        }
    }

    /**
     * 围绕节点右旋
     *
     * @param oldRoot the node to rotate rightly
     */
    private void rotateRight(AVLTreeNode oldRoot) {
        AVLTreeNode newRoot = oldRoot.getLeftChild();
        // 如果newRoot有右子节点，那么令其为oldRoot的左子节点。如果没有，旧根节点的左子节点置空
        if (newRoot.hasRightChild()) {
            newRoot.getRightChild().setParent(oldRoot);
            oldRoot.setLeftChild(newRoot.getRightChild());
        } else {
            oldRoot.setLeftChild(null);
        }


        // 处理oldRoot父节点的引用关系
        if (oldRoot == getRoot()) {
            setRoot(newRoot);
            newRoot.setParent(null);
        } else if (oldRoot.isLeftChild()) {
            oldRoot.getParent().setLeftChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        } else if (oldRoot.isRightChild()) {
            oldRoot.getParent().setRightChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        }

        // 用新根代替旧根
        newRoot.setRightChild(oldRoot);
        oldRoot.setParent(newRoot);

        // 旋转结束后调整平衡因子
        oldRoot.setBalanceFactor(oldRoot.getBalanceFactor() - 1 - Math.max(newRoot.getBalanceFactor(), 0));
        newRoot.setBalanceFactor(newRoot.getBalanceFactor() - 1 + Math.min(oldRoot.getBalanceFactor(), 0));
    }

    /**
     * 围绕节点左旋
     *
     * @param oldRoot the node to rotate rightly
     */
    private void rotateLeft(AVLTreeNode oldRoot) {
        AVLTreeNode newRoot = oldRoot.getRightChild();
        // 如果newRoot有左子节点，那么令其为oldRoot的右子节点。如果没有，旧根节点的右子节点置空
        if (newRoot.hasLeftChild()) {
            newRoot.getLeftChild().setParent(oldRoot);
            oldRoot.setRightChild(newRoot.getLeftChild());
        } else {
            oldRoot.setRightChild(null);
        }


        // 处理oldRoot父节点的引用关系
        if (oldRoot == getRoot()) {
            setRoot(newRoot);
            newRoot.setParent(null);
        } else if (oldRoot.isLeftChild()) {
            oldRoot.getParent().setLeftChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        } else if (oldRoot.isRightChild()) {
            oldRoot.getParent().setRightChild(newRoot);
            newRoot.setParent(oldRoot.getParent());
        }
        // 用新根代替旧根
        newRoot.setLeftChild(oldRoot);
        oldRoot.setParent(newRoot);

        // 旋转结束后调整平衡因子
        oldRoot.setBalanceFactor(oldRoot.getBalanceFactor() + 1 - Math.min(newRoot.getBalanceFactor(), 0));
        newRoot.setBalanceFactor(newRoot.getBalanceFactor() + 1 + Math.max(oldRoot.getBalanceFactor(), 0));
    }


}
